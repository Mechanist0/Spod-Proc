package main;
import java.sql.Timestamp;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
    int offline_timestamp;
    Boolean incognito_mode;

    public EndSongObject(JsonObject obj) {
        String tempStamp = obj.get("ts").getAsString(); //yyyy-mm-ddT14:07:59Z //yyyy-mm-dd hh:mm:ss[.fffffffff] 
        tempStamp = tempStamp.replace("T", " ").replace("Z", " ");
        this.ts = Timestamp.valueOf(tempStamp);
        this.username = obj.get("username").getAsString();
        this.platform = obj.get("platform").getAsString();
        this.ms_played = obj.get("ms_played").getAsInt();
        this.conn_country = obj.get("conn_country").getAsString();
        this.ip_addr_decrypted = obj.get("ip_addr_decrypted").getAsString();
        this.user_agent_decrypted = new Gson().fromJson(obj, UserAgentDecrypted.class).user_agent_decrypted;
        this.master_metadata_track_name = new Gson().fromJson(obj, MasterMetadataTrackName.class).master_metadata_track_name;
        this.master_metadata_album_artist_name = new Gson().fromJson(obj, MasterMetadataAlbumArtistName.class).master_metadata_album_artist_name;
        this.master_metadata_album_album_name = new Gson().fromJson(obj, MasterMetadataAlbumAlbumName.class).master_metadata_album_album_name;
        this.spotify_track_uri = new Gson().fromJson(obj, SpotifyTrackUri.class).spotify_track_uri;
        this.episode_name = new Gson().fromJson(obj, EpisodeName.class).episode_name;
        this.episode_show_name = new Gson().fromJson(obj, EpisodeShowName.class).episode_show_name;
        this.spotify_episode_uri = new Gson().fromJson(obj, SpotifyEpisodeUri.class).spotify_episode_uri;
        this.reason_start = obj.get("reason_start").getAsString();
        this.reason_end = obj.get("reason_end").getAsString();
        this.shuffle = new Gson().fromJson(obj, Shuffle.class).shuffle;
        this.skipped = new Gson().fromJson(obj, Skipped.class).skipped;
        this.offline = new Gson().fromJson(obj, Offline.class).offline;
        this.offline_timestamp = new Gson().fromJson(obj, OfflineTimestamp.class).offline_timestamp;
        this.incognito_mode = new Gson().fromJson(obj, IncognitoMode.class).incognito_mode;
    }
    public EndSongObject() {
        this.ts = null;
        this.username = null;
        this.platform = null;
        this.ms_played = 0;
        this.conn_country = null;
        this.ip_addr_decrypted = null;
        this.user_agent_decrypted = null;
        this.master_metadata_track_name = null;
        this.master_metadata_album_artist_name = null;
        this.master_metadata_album_album_name = null;
        this.spotify_track_uri = null;
        this.episode_name = null;
        this.episode_show_name = null;
        this.spotify_episode_uri = null;
        this.reason_start = null;
        this.reason_end = null;
        this.shuffle = null;
        this.skipped = null;
        this.offline = null;
        this.offline_timestamp = 0;
        this.incognito_mode = null;
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

    public StartReason getReason_start() {
        
        return StartReason.valueOf(reason_start);
    }

    public void setReason_start(String reason_start) {
        this.reason_start = reason_start;
    }

    public EndReason getReason_end() {
        if(reason_end.equals("unexpected-exit-while-paused")) return EndReason.unexpectedexitwhilepaused;
        if(reason_end.equals("unexpected-exit")) return EndReason.unexpectedexit;
        return EndReason.valueOf(reason_end);
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

    public int getOffline_timestamp() {
        return offline_timestamp;
    }

    public void setOffline_timestamp(int offline_timestamp) {
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

    //Convert EndSongObject To Json
    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return this.getMaster_metadata_track_name();
    }

    public enum StartReason {
        trackdone, 
        backbtn, 
        clickrow, 
        fwdbtn, 
        appload, 
        playbtn, 
        trackerror, 
        remote, 
        unknown, 
        endplay,
    }
    
    public enum EndReason {
        trackdone,
        backbtn, 
        fwdbtn, 
        endplay, 
        unexpectedexitwhilepaused, 
        logout, 
        remote, 
        unexpectedexit, 
        unknown, 
        trackerror,
    }
}
class TS {
    public Timestamp ts;
}
class UserAgentDecrypted {
    public String user_agent_decrypted;
}
class MasterMetadataTrackName {
    public String master_metadata_track_name;
}
class MasterMetadataAlbumArtistName {
    public String master_metadata_album_artist_name;
}
class MasterMetadataAlbumAlbumName {
    public String master_metadata_album_album_name;
}
class SpotifyTrackUri {
    public String spotify_track_uri;
}
class EpisodeName {
    public String episode_name;
}
class EpisodeShowName {
    public String episode_show_name;
}
class SpotifyEpisodeUri {
    public String spotify_episode_uri;
}
class Shuffle {
    public Boolean shuffle;
}
class Skipped {
    public Boolean skipped;
}
class Offline {
    public Boolean offline;
}
class OfflineTimestamp {
    public int offline_timestamp;
}
class IncognitoMode {
    public Boolean incognito_mode;
}



