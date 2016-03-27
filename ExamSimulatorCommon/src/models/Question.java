package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question implements Serializable {

    private final String username;
    private String topic;
    private String description;
    private final List<Answer> answers;

    public Question(String username, String topic,
            String description, List<Answer> answers) {
        this.username = username;
        this.topic = topic;
        this.description = description;
        this.answers = answers;
    }

    public Question(String username, String topic, String description) {
        this(username, topic, description, new ArrayList<Answer>());
    }

    public String getUsername() {
        return username;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public int hashCode() {
        return username.length() * 10 + topic.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.topic, other.topic)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

}
