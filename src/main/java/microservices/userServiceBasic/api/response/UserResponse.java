package microservices.userServiceBasic.api.response;


import microservices.userServiceBasic.api.model.UserDetails;

import java.util.UUID;

public class UserResponse extends UserDetails {

	private boolean responseSuccessful;

	public UserResponse(UUID id, String name, String lastName, String email) {
		super(id, name, lastName, email);
		this.setResponseSuccessful(true);
	}

	public UserResponse(UserDetails userDetails) {
		super(userDetails.getId(), userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail());
		this.setResponseSuccessful(true);
	}

	public boolean isResponseSuccessful() {
		return responseSuccessful;
	}

	public void setResponseSuccessful(boolean responseSuccessful) {
		this.responseSuccessful = responseSuccessful;
	}
}
