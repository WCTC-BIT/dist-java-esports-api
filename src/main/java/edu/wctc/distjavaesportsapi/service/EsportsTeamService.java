package edu.wctc.distjavaesportsapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import edu.wctc.distjavaesportsapi.entity.EsportsTeam;
import edu.wctc.distjavaesportsapi.exception.InvalidRequestException;
import edu.wctc.distjavaesportsapi.exception.ResourceNotFoundException;
import edu.wctc.distjavaesportsapi.repository.EsportsTeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EsportsTeamService {
    private final EsportsTeamRepository esportsTeamRepository;
    private final ObjectMapper objectMapper;


    public EsportsTeamService(EsportsTeamRepository esportsTeamRepository, ObjectMapper objectMapper) {
        this.esportsTeamRepository = esportsTeamRepository;
        this.objectMapper = objectMapper;
    }

    public List<EsportsTeam> findAll() {
        List<EsportsTeam> list = new ArrayList<>();
        esportsTeamRepository.findAll().forEach(list::add);
        return list;
    }

    public EsportsTeam findById(int id) {
        return esportsTeamRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("EsportsTeam", id)
        );
    }

    public EsportsTeam createTeam(EsportsTeam team) {
        team.setId(0);
        return esportsTeamRepository.save(team);
    }

    public EsportsTeam updateTeam(EsportsTeam team) {
        return esportsTeamRepository.save(team);
    }

    public EsportsTeam patchTeam(int id, JsonPatch patch) {
        try {
            EsportsTeam existingTeam = findById(id);
            JsonNode patched = patch.apply(objectMapper.convertValue(existingTeam, JsonNode.class));
            EsportsTeam patchedTeam = objectMapper.treeToValue(patched, EsportsTeam.class);
            esportsTeamRepository.save(patchedTeam);
            return patchedTeam;
        } catch (JsonPatchException | JsonProcessingException exception) {
            throw new InvalidRequestException("Unable to update Esports Team");
        }
    }

    public void deleteTeam(int id) {
        esportsTeamRepository.deleteById(id);
    }
}
