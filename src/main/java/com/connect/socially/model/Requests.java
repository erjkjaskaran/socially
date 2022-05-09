package com.connect.socially.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="requests", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="user_id", nullable = false)
    private User userid;

    @ManyToOne
    @JoinColumn(name="requestinguser_id", nullable = false)
    private User requestingid;

    public Requests(User user_id, User requesting_id) {
        this.userid = user_id;
        this.requestingid = requesting_id;
    }
}
