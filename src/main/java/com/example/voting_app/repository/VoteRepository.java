package com.example.voting_app.repository;

import com.example.voting_app.model.Vote;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoteRepository {

    private List<Vote> votes;

    // Initialize with default vote counts
    public VoteRepository() {
        votes = new ArrayList<>();
        votes.add(new Vote("Action/Adventure", 0));
        votes.add(new Vote("Rom-Com", 0));
        votes.add(new Vote("Horror", 0));
    }

    // Get all votes
    public List<Vote> getVotes() {
        return votes;
    }

    // Increment the vote count for the selected genre
    public void incrementVote(String genre) {
        for (Vote vote : votes) {
            if (vote.getGenre().equals(genre)) {
                vote.incrementCount();
                break;
            }
        }
    }
}
