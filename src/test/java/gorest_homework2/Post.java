package gorest_homework2;

public class Post {
    private int id;
    private int user_id;
    private String title;
    private String body;

    Post() { }

    Post(int id, int user_id, String title, String body) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "\n{" +
                "\"id\":" + id + ",\n" +
                "\"user_id\":" + user_id + ",\n" +
                "\"title\":" + title + ",\n" +
                "\"body\":" + body + "\n}";
    }
}
