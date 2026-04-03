package api.services;

import api.base.utils.APIBaseService;
import api.request.models.PostModel;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostsService extends APIBaseService {

	private static String POSTS_ENDPOINT = "/posts";

	public PostsService() {
		baseRequestSpecification.basePath(POSTS_ENDPOINT);
	}

	public Response getAllPosts() {
		return sendGetRequest();
	}

	public Response getPosts(int postId) {
		return sendGetRequest("/" + postId);
	}

	public Response createPost(PostModel model) {
		return sendPostRequest(model);
	}

	
	public RequestSpecification getBaseRequest() {

		return baseRequestSpecification;
	}
}
