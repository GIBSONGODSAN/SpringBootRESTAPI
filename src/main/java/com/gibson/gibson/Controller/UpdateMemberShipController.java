package com.gibson.gibson.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import  org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.gibson.gibson.domain.UpdateMemberRequest;
import com.gibson.gibson.domain.User;
import com.gibson.gibson.service.userService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UpdateMemberShipController {

  @Autowired
  private userService userService;

  @PostMapping("/updateMembership")
  public ResponseEntity<User> updateMembership(@RequestBody UpdateMemberRequest request) {
    String email = request.getEmail();
    boolean isMember = request.getIsMember();

    User updatedUser = userService.updateMembership(email, isMember);

    if (updatedUser == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }
}
