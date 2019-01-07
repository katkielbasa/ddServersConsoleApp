package org.katkielbasa.dimensiondatasimpleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
    @NamedQuery(
        name = "findServerById",
        query = "from Server s where s.id = :id"
        ),

    @NamedQuery(
        name = "countAllServers",
        query = "select count(*) from Server"
        ),
    @NamedQuery(
            name = "findAllServers",
            query = "from Server"
            )
})
@Entity
@Table(name = "server")
public class Server {

	@Id
	@Column(name = "id", nullable = false, unique=true)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;
	
	public Server() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Server)) return false;
//		return EqualsBuilder.reflectionEquals(this,obj);
//	}


}
