--Query to return all employees with personal information
--select e.E_ID as EmployeeId, e.E_USERNAME as username, concat(concat(ei.e_firstname, ' '), ei.e_lastname) as Name, ei.e_email as Email 
--from employee e 
--    inner join employee_info ei 
--    on e.e_id = ei.e_info_id;


--Alter Employee Personal Information table to add mailing address
alter table employee_info add (
    address varchar2(30),
    city varchar2(20),
    state varchar2(20),
    zipcode varchar2(10)
);


--Alter stored prcedure to accomodate personal information table
create or replace procedure insert_employee(
username varchar, password varchar, firstname varchar, lastname varchar, email varchar, address varchar2, city VARCHAR2, 
state varchar2, zipcode varchar2)
is
begin
    insert into employee values(null, username, password);
    insert into employee_info values (employee_seq.currval, firstname, lastname, email, address, city, state, zipcode);
    commit;
end;


--Reinitialize Employee Sequence to begin with 1
--drop sequence "ADMINERS"."EMPLOYEE_SEQ";
create sequence employee_seq
    start with 1
    increment by 1;

alter table pending_request
    add status varchar2(10);

alter table pending_request
    modify status default 'Pending';



select * from resolved_request;
