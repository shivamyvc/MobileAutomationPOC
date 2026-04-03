package api.request.models;

public class PostModel {

	private int userId;
	private int id;
	private String title;
	private String body;

	private PostModel(int userId, int id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static class Builder {
		private int userId;
		private int id;
		private String title;
		private String body;

		public Builder userId(int userId) {
			this.userId = userId;
			return this;
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder body(String body) {
			this.body = body;
			return this;
		}

		public PostModel build() {
			return new PostModel(userId, id, title, body);
		}

	}

}
