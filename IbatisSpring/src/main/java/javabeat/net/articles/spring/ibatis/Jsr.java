package javabeat.net.articles.spring.ibatis;

import java.util.List;


public class Jsr
{
    private String id;
    private String name;
    private String description;
    private String specLead;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getSpecLead()
    {
        return specLead;
    }

    public void setSpecLead(String specLead)
    {
        this.specLead = specLead;
    }

	@Override
	public String toString() {
		return "Jsr [id=" + id + ", name=" + name + ", description=" + description + ", specLead=" + specLead + "]";
	}

}