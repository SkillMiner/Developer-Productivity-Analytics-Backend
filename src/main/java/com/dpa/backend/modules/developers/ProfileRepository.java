package com.dpa.backend.modules.developers;

import com.dpa.backend.modules.developers.entities.Profile;
import com.dpa.backend.modules.stats.entities.DevelopersSummary;
import com.dpa.backend.modules.stats.entities.ProfileRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT new com.dpa.backend.modules.stats.entities.DevelopersSummary( " +
            "       COUNT(DISTINCT d.id), " +
            "       SUM(p.totalCommitContributions), " +
            "       SUM(p.totalPullRequestContributions), " +
            "       SUM(p.totalPullRequestReviewContributions), " +
            "       SUM(p.totalIssueContributions), " +
            "       SUM(p.totalRepositoryContributions), " +
            "       SUM(p.totalRepositoriesWithContributedIssues), " +
            "       SUM(p.totalRepositoriesWithContributedCommits), " +
            "       SUM(p.totalRepositoriesWithContributedPullRequests), " +
            "       SUM(p.totalRepositoriesWithContributedPullRequestReviews)) " +
            " FROM Profile p join Developer d on d.id = p.developer.id " +
            " WHERE p.gitPlatform = 'GITHUB'")
    DevelopersSummary accumulatedValuesQuery();

    @Query("SELECT new com.dpa.backend.modules.stats.entities.ProfileRank( " +
            "    p.login, " +
            "    p.name, " +
            "    p.totalStars," +
            "    p.totalRepositories," +
            "    wc.totalCommitContributions," +
            "    wc.totalPullRequestContributions," +
            "    wc.totalIssueContributions," +
            "    wc.totalRepositoryContributions," +
            "    wc.totalPullRequestReviewContributions) " +
            " FROM Profile p join WeeklyContribution wc on p.id = wc.profile.id" +
            " WHERE p.gitPlatform = 'GITHUB'")
    List<ProfileRank> githubProfileRanksQuery();
}
