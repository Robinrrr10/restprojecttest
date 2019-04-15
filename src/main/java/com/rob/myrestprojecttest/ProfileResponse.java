package com.rob.myrestprojecttest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="profileResponse")
public class ProfileResponse {

	private Status status;
	private ProfileEntry profileEntry;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public ProfileEntry getProfileEntry() {
		return profileEntry;
	}
	public void setProfileEntry(ProfileEntry profileEntry) {
		this.profileEntry = profileEntry;
	}
}
