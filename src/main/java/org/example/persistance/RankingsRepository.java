package org.example.persistance;

public interface RankingsRepository {
    void addRankingItem(int rank, String competitorName, double totalDistance);

    void close();
}
