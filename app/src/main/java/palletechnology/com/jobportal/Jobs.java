package palletechnology.com.jobportal;

/**
 * Created by Admin on 08-02-2017.
 */

public class Jobs {
    String jobsId,date,cname,city,experience,jobType,technology,descreption;

    public Jobs(String jobsId, String date, String cname, String city, String experience, String jobType, String technology, String descreption) {
        this.jobsId = jobsId;
        this.date = date;
        this.cname = cname;
        this.city = city;
        this.experience = experience;
        this.jobType = jobType;
        this.technology = technology;
        this.descreption = descreption;
    }

    public String getJobsId() {
        return jobsId;
    }

    public void setJobsId(String jobsId) {
        this.jobsId = jobsId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
