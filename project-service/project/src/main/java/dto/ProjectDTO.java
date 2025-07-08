package dto;

import java.time.LocalDateTime;

public class ProjectDTO {

	private String id;
	
	private String title;
	
	private String description;
	
	private LocalDateTime startDate;
	
  private LocalDateTime endDate;
	  
	  private String status;
	  
	  private String userId;

	  public String getId() {
		  return id;
	  }

	  public void setId(String id) {
		  this.id = id;
	  }

	  public String getTitle() {
		  return title;
	  }

	  public void setTitle(String title) {
		  this.title = title;
	  }

	  public String getDescription() {
		  return description;
	  }

	  public void setDescription(String description) {
		  this.description = description;
	  }

	  public LocalDateTime getStartDate() {
		  return startDate;
	  }

	  public void setStartDate(LocalDateTime startDate) {
		  this.startDate = startDate;
	  }

	  public LocalDateTime getEndDate() {
		  return endDate;
	  }

	  public void setEndDate(LocalDateTime endDate) {
		  this.endDate = endDate;
	  }

	  public String getStatus() {
		  return status;
	  }

	  public void setStatus(String status) {
		  this.status = status;
	  }

	  public String getUserId() {
		  return userId;
	  }

	  public void setUserId(String userId) {
		  this.userId = userId;
	  }
	  
	  
}
