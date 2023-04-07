package dataAccess;

import model.Follower;

public interface FollowerDataAccess {
    Follower getFollower(Follower follower);
    void setFollower(Follower parent, Follower child);
}
