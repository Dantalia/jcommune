/**
 * Copyright (C) 2011  JTalks.org Team
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package org.jtalks.jcommune.model.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.jtalks.common.model.entity.User;
import org.jtalks.common.validation.annotations.Email;
import org.jtalks.jcommune.model.entity.JCUser;
import org.jtalks.jcommune.model.entity.Language;
import org.jtalks.jcommune.model.validation.annotations.Unique;

import javax.validation.constraints.Size;

/**
 * @author Andrey Pogorelov
 */
public class UserDto {

    @NotBlank(message = "{validation.not_null}")
    @Size(min = User.USERNAME_MIN_LENGTH, max = User.USERNAME_MAX_LENGTH, message = "{user.username.length_constraint_violation}")
    @Unique(entity = JCUser.class, field = "username", message = "{user.username.already_exists}", ignoreCase = true)
    private String username;

    @NotBlank(message = "{validation.not_null}")
    @Size(max = User.EMAIL_MAX_LENGTH, message = "{user.email.illegal_length}")
    @Email(message = "{validation.invalid_email_format}")
    @Unique(entity = JCUser.class, field = "email", message = "{user.email.already_exists}", ignoreCase = true)
    private String email;

    @NotBlank(message = "{validation.not_null}")
    @Size(min = User.PASSWORD_MIN_LENGTH, max = User.PASSWORD_MAX_LENGTH)
    private String password;

    private Language language = Language.ENGLISH;

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username.
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password.
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get email.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email.
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return user language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * @param language of user
     */
    public void setLanguage(Language language) {
        this.language = language;
    }
}