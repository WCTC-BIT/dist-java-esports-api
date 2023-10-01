package edu.wctc.distjavaesportsapi.controller;

import com.github.fge.jsonpatch.JsonPatch;
import edu.wctc.distjavaesportsapi.entity.EsportsTeam;
import edu.wctc.distjavaesportsapi.service.EsportsTeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class EsportsTeamController {

    private final EsportsTeamService esportsTeamService;

    public EsportsTeamController(EsportsTeamService esportsTeamService) {
        this.esportsTeamService = esportsTeamService;
    }

    @GetMapping
    public List<EsportsTeam> getAllTeams() {
        return esportsTeamService.findAll();
    }

    @GetMapping("/{teamId}")
    public EsportsTeam getTeam(@PathVariable int teamId) {
        return esportsTeamService.findById(teamId);
    }

    @PostMapping
    public EsportsTeam createTeam(@RequestBody EsportsTeam team) {
        return esportsTeamService.createTeam(team);
    }

    @PutMapping
    public EsportsTeam updateTeam(@RequestBody EsportsTeam team) {
        return esportsTeamService.updateTeam(team);
    }

    @PatchMapping("/{teamId}")
    public EsportsTeam patchTeam(@PathVariable int teamId, @RequestBody JsonPatch patch) {
        return esportsTeamService.patchTeam(teamId, patch);
    }

    @DeleteMapping("/{teamId}")
    public String deleteTeam(@PathVariable int teamId) {
        esportsTeamService.deleteTeam(teamId);
        return "Successfully deleted team with ID " + teamId;
    }
}
