package com.example.voting_app.service;

import com.example.voting_app.model.Vote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VotingService {

    private List<Vote> votes;

    public VotingService() {
        votes = new ArrayList<>();
        // Initialize with default values
        votes.add(new Vote("Action/Adventure", 0));
        votes.add(new Vote("Rom-Com", 0));
        votes.add(new Vote("Horror", 0));
    }

    // Increment the vote for a genre
    public void incrementVote(String genre) {
        for (Vote vote : votes) {
            if (vote.getGenre().equals(genre)) {
                vote.setCount(vote.getCount() + 1);
                break;
            }
        }
    }

    // Get the current votes
    public List<Vote> getVotes() {
        return votes;
    }
}
