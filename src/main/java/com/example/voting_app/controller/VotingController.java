package com.example.voting_app.controller;

import com.example.voting_app.repository.VoteRepository;
import com.example.voting_app.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VotingController {

    @Autowired
    private VoteRepository voteRepository;

    // Display the voting form and vote counts
    @GetMapping("/")
    public String showVotingForm(Model model) {
        List<Vote> votes = voteRepository.getVotes();
        model.addAttribute("votes", votes);
        return "index";  // Thymeleaf template
    }

    // Handle the form submission
    @PostMapping("/vote")
    public String submitVote(String genre, Model model) {
        voteRepository.incrementVote(genre);  // Increment the vote for the selected genre
        List<Vote> votes = voteRepository.getVotes();  // Get updated vote counts
        model.addAttribute("votes", votes);
        return "index";  // Redirect back to the same page with updated votes
    }
}
