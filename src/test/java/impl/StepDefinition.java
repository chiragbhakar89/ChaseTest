package impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.CreateComment;
import model.CreatePostRequest;
import model.GetPostResponse;
import restAssured.DeleteService;
import restAssured.GetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import restAssured.PostService;
import restAssured.PutService;

import java.util.*;

public class StepDefinition {

    List<Map<String, Object>> responseMap = new ArrayList<>();
    Response response;
    ObjectMapper objectMapper = new ObjectMapper();
    int postID;

    int userID;


    @Given("an existing post")
    public void anExistingPost() throws JsonProcessingException {
        responseMap = GetService.get("posts").then().extract().response().jsonPath().get();
        postID = Integer.parseInt(responseMap.get(0).get("id").toString());
    }

    @Given("a valid user")
    public void aValidUser() {
        responseMap = GetService.get("posts").then().extract().response().jsonPath().get();
        userID = Integer.parseInt(responseMap.get(0).get("userId").toString());
    }

    @Given("an invalid user")
    public void anInValidUser() {
    System.out.println("Invalid user!!");
    }

    @Given("admin access")
    public void adminAccess() {
    }

    @When("I get users")
    public void getUsers() {
        response = GetService.get("users");
    }

    @When("user create following post: {string}")
    public void createPost(String post) throws JsonProcessingException {
    Random random = new Random();
    postID = random.nextInt((90) + 10);
    response = PostService.post("posts", objectMapper.writeValueAsString(createPostRequest("New Post", post, postID)));
    }

    @When("user edits the post: {string}")
    public void editPost(String editedPost) throws JsonProcessingException {
        response = PutService.put(objectMapper.writeValueAsString(createPostRequest("New Post",editedPost, postID)), "posts");
    }

    @When("user delete a post")
    public void deletePost() {
       response =  DeleteService.delete("posts/"+postID);
    }

    @When("user comment following on the post: {string}")
    public void userCommentOnPost(String comment) throws JsonProcessingException {
        response = PostService.post("comments", objectMapper.writeValueAsString(createComment(comment)));
    }

    @Then("{int} response code should be returned")
    public void assertResponse(int statusCode) {
        response.then().statusCode(statusCode);
    }

    public CreateComment createComment(String comment) {
        CreateComment createComment = new CreateComment();
        createComment.setPostId(postID);
        createComment.setBody(comment);
        createComment.setEmail("abc@gmail.com");
        createComment.setName("name");
        return createComment;
    }

    public CreatePostRequest createPostRequest(String title, String body, int postID) {
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setUserId(userID);
        createPostRequest.setBody(body);
        createPostRequest.setTitle(title);
        createPostRequest.setPostId(postID);
        return createPostRequest;
    }
}
