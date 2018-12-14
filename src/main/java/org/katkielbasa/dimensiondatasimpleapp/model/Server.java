package org.katkielbasa.dimensiondatasimpleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
            name = "findAllServer",
            query = "from Server"
            )
})
@Entity
@Table(name = "server")
public class Server {

	@Id
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;
	
	public Server() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
