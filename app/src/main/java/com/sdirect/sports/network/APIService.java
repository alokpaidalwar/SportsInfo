package com.sdirect.sports.network;


import com.sdirect.sports.model.AllLeagues;
import com.sdirect.sports.model.AllPlayers;
import com.sdirect.sports.model.AllSports;
import com.sdirect.sports.model.AllTeamsInLeague;
import com.sdirect.sports.model.News;
import com.sdirect.sports.model.Results;
import com.sdirect.sports.model.ScoreDetailsTeamInLeague;
import com.sdirect.sports.model.TeamEventsNext;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIService {

    @GET("all_sports.php")
    Observable<AllSports> getAllSportsList();

    @GET("all_leagues.php")
    Observable<AllLeagues> getAllLeaguesList();

    @GET("lookup_all_teams.php?")
    Observable<AllTeamsInLeague> getAllTeamsInLeagueList(@Query("id") String id);

    @GET("lookup_all_players.php?")
    Observable<AllPlayers> getAllPlayersInTeamList(@Query("id") String id);

    @GET("lookuptable.php?")
    Observable<ScoreDetailsTeamInLeague> getScoreDetailsTeamsInLeagueList(@Query("l") String id);

    @GET("eventsnextleague.php?")
    Observable<TeamEventsNext> getLeagueEventNext(@Query("id") String id);

    @GET("eventsnext.php?")
    Observable<TeamEventsNext> getTeamEventNext(@Query("id") String id);

    @GET("searchteams.php?")
    Observable<AllTeamsInLeague> findTeam(@Query("t") String teamName);

    @GET("eventsday.php?")
    Observable<TeamEventsNext> getDayEvent(@Query("d") String todayDate);

    @GET("eventspastleague.php?")
    Observable<TeamEventsNext> getLeagueEventPast(@Query("id") String id);

    @GET("eventslast.php?")
    Observable<Results> getTeamEventPast(@Query("id") String id);

    @GET("top-headlines?sources=the-sport-bible&apiKey=9e398efba052490e8e6c89542c784df2")
    Observable<News> getNews();

}

