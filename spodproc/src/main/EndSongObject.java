package main;
import java.sql.Timestamp;
import com.google.gson.Gson; 

/*
  "ts": "YYY-MM-DD 13:30:30", when the track stopped playing in UTC (Coordinated Universal Time).
  "username": "_________", 
  "platform": "_________", 
  "ms_played": _________, 
  "conn_country": "_________", 
  "ip_addr_decrypted": "___.___.___.___", 
  "user_agent_decrypted": "_________", 
  "master_metadata_track_name": "_________, 
  “master_metadata_album_artist_name:_________”, 
  “master_metadata_album_album_name:_________", 
  “spotify_track_uri:_________”, 
  "episode_name": _________, 
  "episode_show_name": _________, 
  “spotify_episode_uri:_________”, 
  "reason_start": "_________", 
  "reason_end": "_________", 
  "shuffle": null/true/false, 
  "skipped": null/true/false, 
  "offline": null/true/false, 
  "offline_timestamp": _________, 
  "incognito_mode": null/true/false, 
 */
public class EndSongObject {
    Timestamp ts;
    String username;
    String platform;
    int ms_played;
    String conn_country;
    String ip_addr_decrypted;
    String user_agent_decrypted;
    String master_metadata_track_name;
    String master_metadata_album_artist_name;
    String master_metadata_album_album_name;
    String spotify_track_uri;
    String episode_name;
    String episode_show_name;
    String spotify_episode_uri;
    String reason_start;
    String reason_end;
    Boolean shuffle;
    Boolean skipped;
    Boolean offline;
    Timestamp offline_timestamp;
    Boolean incognito_mode;

    public EndSongObject(Timestamp ts, String username, String platform, int ms_played, String conn_country, String ip_addr_decrypted, String user_agent_decrypted, String master_metadata_track_name, String master_metadata_album_artist_name, String master_metadata_album_album_name, String spotify_track_uri, String episode_name, String episode_show_name, String spotify_episode_uri, String reason_start, String reason_end, Boolean shuffle, Boolean skipped, Boolean offline, Timestamp offline_timestamp, Boolean incognito_mode) {
        this.ts = ts;
        this.username = username;
        this.platform = platform;
        this.ms_played = ms_played;
        this.conn_country = conn_country;
        this.ip_addr_decrypted = ip_addr_decrypted;
        this.user_agent_decrypted = user_agent_decrypted;
        this.master_metadata_track_name = master_metadata_track_name;
        this.master_metadata_album_artist_name = master_metadata_album_artist_name;
        this.master_metadata_album_album_name = master_metadata_album_album_name;
        this.spotify_track_uri = spotify_track_uri;
        this.episode_name = episode_name;
        this.episode_show_name = episode_show_name;
        this.spotify_episode_uri = spotify_episode_uri;
        this.reason_start = reason_start;
        this.reason_end = reason_end;
        this.shuffle = shuffle;
        this.skipped = skipped;
        this.offline = offline;
        this.offline_timestamp = offline_timestamp;
        this.incognito_mode = incognito_mode;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getMs_played() {
        return ms_played;
    }

    public void setMs_played(int ms_played) {
        this.ms_played = ms_played;
    }

    public String getConn_country() {
        return conn_country;
    }

    public void setConn_country(String conn_country) {
        this.conn_country = conn_country;
    }

    public String getIp_addr_decrypted() {
        return ip_addr_decrypted;
    }

    public void setIp_addr_decrypted(String ip_addr_decrypted) {
        this.ip_addr_decrypted = ip_addr_decrypted;
    }

    public String getUser_agent_decrypted() {
        return user_agent_decrypted;
    }

    public void setUser_agent_decrypted(String user_agent_decrypted) {
        this.user_agent_decrypted = user_agent_decrypted;
    }

    public String getMaster_metadata_track_name() {
        return master_metadata_track_name;
    }

    public void setMaster_metadata_track_name(String master_metadata_track_name) {
        this.master_metadata_track_name = master_metadata_track_name;
    }

    public String getMaster_metadata_album_artist_name() {
        return master_metadata_album_artist_name;
    }

    public void setMaster_metadata_album_artist_name(String master_metadata_album_artist_name) {
        this.master_metadata_album_artist_name = master_metadata_album_artist_name;
    }

    public String getMaster_metadata_album_album_name() {
        return master_metadata_album_album_name;
    }

    public void setMaster_metadata_album_album_name(String master_metadata_album_album_name) {
        this.master_metadata_album_album_name = master_metadata_album_album_name;
    }

    public String getSpotify_track_uri() {
        return spotify_track_uri;
    }

    public void setSpotify_track_uri(String spotify_track_uri) {
        this.spotify_track_uri = spotify_track_uri;
    }

    public String getEpisode_name() {
        return episode_name;
    }

    public void setEpisode_name(String episode_name) {
        this.episode_name = episode_name;
    }

    public String getEpisode_show_name() {
        return episode_show_name;
    }

    public void setEpisode_show_name(String episode_show_name) {
        this.episode_show_name = episode_show_name;
    }

    public String getSpotify_episode_uri() {
        return spotify_episode_uri;
    }

    public void setSpotify_episode_uri(String spotify_episode_uri) {
        this.spotify_episode_uri = spotify_episode_uri;
    }

    public String getReason_start() {
        return reason_start;
    }

    public void setReason_start(String reason_start) {
        this.reason_start = reason_start;
    }

    public String getReason_end() {
        return reason_end;
    }

    public void setReason_end(String reason_end) {
        this.reason_end = reason_end;
    }

    public Boolean getShuffle() {
        return shuffle;
    }

    public void setShuffle(Boolean shuffle) {
        this.shuffle = shuffle;
    }

    public Boolean getSkipped() {
        return skipped;
    }

    public void setSkipped(Boolean skipped) {
        this.skipped = skipped;
    }

    public Boolean getOffline() {
        return offline;
    }

    public void setOffline(Boolean offline) {
        this.offline = offline;
    }

    public Timestamp getOffline_timestamp() {
        return offline_timestamp;
    }

    public void setOffline_timestamp(Timestamp offline_timestamp) {
        this.offline_timestamp = offline_timestamp;
    }

    public Boolean getIncognito_mode() {
        return incognito_mode;
    }

    public void setIncognito_mode(Boolean incognito_mode) {
        this.incognito_mode = incognito_mode;
    }

    //Convert EndSongObject From Json
    public static EndSongObject fromJson(String json) {
        Gson gson = new Gson();
        EndSongObject endSongObject = gson.fromJson(json, EndSongObject.class);
        return endSongObject;
    }
}