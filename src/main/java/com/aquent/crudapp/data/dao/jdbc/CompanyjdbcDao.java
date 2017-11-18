package com.aquent.crudapp.data.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.aquent.crudapp.data.dao.CompanyDao;
import com.aquent.crudapp.domain.Company;

public class CompanyjdbcDao implements CompanyDao {

  private static final String SQL_LIST_PEOPLE = "SELECT * FROM company ORDER BY company_name, company_id";
  private static final String SQL_READ_PERSON = "SELECT * FROM company WHERE company_id = :companyId";
  private static final String SQL_DELETE_PERSON = "DELETE FROM company WHERE company_id = :companyId";
  private static final String SQL_UPDATE_PERSON = "UPDATE company SET (company_name, web_uri, phone_number, street_address, city, state, zip_code)"
      + " = (:name, :webUri, :phoneNumber, :streetAddress, :city, :state, :zipCode)"
      + " WHERE company_id = :companyId";
  private static final String SQL_CREATE_PERSON = "INSERT INTO company (name, phone_number, street_address, city, state, zip_code)"
      + " VALUES (:name, :website, :phoneNumber, :streetAddress, :city, :state, :zipCode)";

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public List<Company> listCompanies() {
    return namedParameterJdbcTemplate.getJdbcOperations().query(SQL_LIST_PEOPLE, new CompanyRowMapper());
  }

  @Override
  public Integer createCompany(Company company) {
    return null;
  }

  @Override
  public Company readCompany(Integer id) {
    return null;
  }

  @Override
  public void updateCompany(Company company) {

  }

  @Override
  public void deleteCompany(Integer companyId) {

  }

  private static final class CompanyRowMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
      Company company = new Company();
      company.setCompanyId(rs.getInt("company_id"));
      company.setCompanyName(rs.getString("company_name"));
      company.setWebUri(rs.getString("web_uri"));
      company.setStreetAddress(rs.getString("street_address"));
      company.setCity(rs.getString("city"));
      company.setState(rs.getString("state"));
      company.setZipCode(rs.getInt("zip_code"));
      return company;
    }
  }
}
