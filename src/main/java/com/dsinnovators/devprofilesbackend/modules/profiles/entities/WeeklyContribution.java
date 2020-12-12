package com.dsinnovators.devprofilesbackend.modules.profiles.entities;

import com.dsinnovators.devprofilesbackend.github.entities.GithubContributionSummary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "weekly_contributions")
@Relation(value = "weeklyContribution", collectionRelation = "weeklyContributions")
public class WeeklyContribution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrib_id_generator")
    @SequenceGenerator(name = "contrib_id_generator", sequenceName = "contrib_id_seq", initialValue = 101)
    private Long id;
    private boolean hasAnyContributions;
    private boolean hasAnyRestrictedContributions;
    private int totalCommitContributions;
    private int totalPullRequestContributions;
    private int totalPullRequestReviewContributions;
    private int totalIssueContributions;
    private int totalRepositoryContributions;
    private int totalRepositoriesWithContributedIssues;
    private int totalRepositoriesWithContributedCommits;
    private int totalRepositoriesWithContributedPullRequests;
    private int totalRepositoriesWithContributedPullRequestReviews;
    private int restrictedContributionsCount;
    private Date startedAt;
    private Date endedAt;

    @JsonIgnore
    @Column(name = "contribution_calendar_json", columnDefinition = "TEXT")
    private String contributionCalendar;

    @Transient
    private JsonNode contributionsCalendar;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "profile_id", nullable = false) // TODO: make nullable false
    private Profile profile;

    public static WeeklyContribution from(GithubContributionSummary contributionSummary,
                                          Profile profile) throws JsonProcessingException {
        return WeeklyContribution.builder()
                                 .hasAnyContributions(contributionSummary.isHasAnyContributions())
                                 .hasAnyRestrictedContributions(contributionSummary.isHasAnyRestrictedContributions())
                                 .totalCommitContributions(contributionSummary.getTotalCommitContributions())
                                 .totalPullRequestContributions(contributionSummary.getTotalPullRequestContributions())
                                 .totalPullRequestReviewContributions(
                                         contributionSummary.getTotalPullRequestReviewContributions())
                                 .totalIssueContributions(contributionSummary.getTotalIssueContributions())
                                 .totalRepositoryContributions(contributionSummary.getTotalRepositoryContributions())
                                 .totalRepositoriesWithContributedIssues(
                                         contributionSummary.getTotalRepositoriesWithContributedIssues())
                                 .totalRepositoriesWithContributedCommits(
                                         contributionSummary.getTotalRepositoriesWithContributedCommits())
                                 .totalRepositoriesWithContributedPullRequests(
                                         contributionSummary.getTotalRepositoriesWithContributedPullRequests())
                                 .totalRepositoriesWithContributedPullRequestReviews(
                                         contributionSummary.getTotalRepositoriesWithContributedPullRequestReviews())
                                 .restrictedContributionsCount(contributionSummary.getRestrictedContributionsCount())
                                 .startedAt(contributionSummary.getStartedAt())
                                 .endedAt(contributionSummary.getEndedAt())
                                 .contributionCalendar(contributionSummary.getContributionCalenderString())
                                 .contributionsCalendar(contributionSummary.getContributionCalendar())
                                 .profile(profile)
                                 .build();
    }

    @Override
    public String toString() {
        return "WeeklyContribution{" +
                "id=" + id +
                ", hasAnyContributions=" + hasAnyContributions +
                ", hasAnyRestrictedContributions=" + hasAnyRestrictedContributions +
                ", totalCommitContributions=" + totalCommitContributions +
                ", totalPullRequestContributions=" + totalPullRequestContributions +
                ", totalPullRequestReviewContributions=" + totalPullRequestReviewContributions +
                ", totalIssueContributions=" + totalIssueContributions +
                ", totalRepositoryContributions=" + totalRepositoryContributions +
                ", totalRepositoriesWithContributedIssues=" + totalRepositoriesWithContributedIssues +
                ", totalRepositoriesWithContributedCommits=" + totalRepositoriesWithContributedCommits +
                ", totalRepositoriesWithContributedPullRequests=" + totalRepositoriesWithContributedPullRequests +
                ", totalRepositoriesWithContributedPullRequestReviews=" + totalRepositoriesWithContributedPullRequestReviews +
                ", restrictedContributionsCount=" + restrictedContributionsCount +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", contributionCalendar='" + contributionCalendar + '\'' +
                ", contributionsCalendar=" + contributionsCalendar +
                '}';
    }
}
