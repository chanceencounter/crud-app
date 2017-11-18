package com.aquent.crudapp.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Prompt calls company and client the same thing. I think for consistency it's better
// to just call it one or the other.

public class Company {
  //  Clients should have a company name, website URI, phone number, and physical/mailing address.

  private Integer companyId;

  @NotNull
  @Size(min = 1, max = 50, message = "Company name is required with maximum length of 50")
  private String companyName;

  @NotNull
  @Size(min = 1, max = 50, message = "URI is required with maximum length of 50")
  private String webUri;

  //Potential things to be aware of: clients outside the US, number reqs.
  @NotNull
  @Size(min = 1, max = 10, message = "Phone numbers [in the US] required with maximum length of 10")
  private Integer phoneNumber;

  @NotNull
  @Size(min = 1, max = 50, message = "Street address is required with maximum length of 50")
  private String streetAddress;

  @NotNull
  @Size(min = 1, max = 50, message = "City is required with maximum length of 50")
  private String city;

  @NotNull
  @Size(min = 2, max = 2, message = "State is required with length 2")
  private String state;

  @NotNull
  @Size(min = 5, max = 5, message = "Zip code is required with length 5")
  private Integer zipCode;


  //  String streetAddress, city, state, zipcode

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(int company_id) {
    this.companyId = companyId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getWebUri() {
    return webUri;
  }

  public void setWebUri(String webUri) {
    this.webUri = webUri;
  }

  public Integer getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Integer phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }

}
