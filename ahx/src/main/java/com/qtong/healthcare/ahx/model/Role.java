package com.qtong.healthcare.ahx.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by ZML on 2015/4/19.
 */

@Entity
@Table( name="t_role")
public class Role implements Serializable {

    private int roleId;

    private String roleName;

    private Set<Action> actions;

    private Set<User> users;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "increment")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
    @OneToMany(targetEntity = Action.class,cascade = CascadeType.ALL)
    @JoinTable(name = "t_role_action",joinColumns = @JoinColumn(name="actionId"),inverseJoinColumns = @JoinColumn(name = "roleId"))
    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    @OneToMany(targetEntity = User.class)
    @JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
