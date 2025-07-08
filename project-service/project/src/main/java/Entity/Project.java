package Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  
	  private String title;
	  
	  private String description;
	  
	  private LocalDateTime startDate;
	  
	  private LocalDateTime endDate;
	  
	  private String status;
	  
	  private Long userId;

	  public Long getId() {
		  return id;
	  }

	  public void setId(Long id) {
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

	  public Long getUserId() {
		  return userId;
	  }

	  public void setUserId(Long userId) {
		  this.userId = userId;
	  }
	  
	  
}
