package com.aquent.crudapp.service;

import java.util.List;

import com.aquent.crudapp.domain.Company;

public interface CompanyService {

  /**
   * Retrieves all of the client records.
   *
   * @return list of client records
   */
  List<Company> listCompanies();

  /**
   * Creates a new company record.
   *
   * @param company the values to save
   * @return the new company ID
   */
  Integer createCompany(Company company);

  /**
   * Retrieves a client record by ID.
   *
   * @param id the client ID
   * @return the client record
   */
  Company readCompany(Integer id);

  /**
   * Updates an existing company record.
   *
   * @param company the new values to save
   */
  void updateCompany(Company company);

  /**
   * Deletes a client record by ID.
   *
   * @param id the client ID
   */
  void deleteCompany(Integer id);

  /**
   * Validates populated company data.
   *
   * @param company the values to validate
   * @return list of error messages
   */
  List<String> validateCompany(Company company);
}
