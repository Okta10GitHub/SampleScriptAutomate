@runningAll
@registrationForm
  Feature: Register New Students
    In order to enroll new students
    As a school administrator
    I want to be able to register new students with their information

    Scenario: Successful registration a new student
      Given I am on the registration page
      When I enter the student's first name "John"and last name "Doe"
      And I enter the student's email "parent@example.com"
      And I select the student's gender as "Male"
      And I enter the student's  mobile phone number "1232321321"
      And I enter the student's date of birth "11 Aug 1999"
      And I enter the student's Subject "English"
      And I select the student's Hobbies as "Sports"
      And I select the student's picture for school documentation
      And I provide the student's address "Jl. sample no.26, Rajeg, Tangerang"
      And I select the student's state and city
      And I click the submit button
      Then I should see a success popup message "Thanks for submitting the form"

