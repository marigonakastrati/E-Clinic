CREATE DATABASE Clinic
use clinic
/****** Object:  Table [dbo].[Address]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
CREATE TABLE Address(
	`city_id` int NOT NULL,
	`building_number` int NOT NULL,
	`street_name` nvarchar(256) NOT NULL,
	`address_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_address_id` PRIMARY KEY 
(
	`address_id` ASC
) 
);

/****** Object:  Table [dbo].[AdminClinic]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE AdminClinic(
	`person_id` int NOT NULL,
	`pass_code` nvarchar(256) NOT NULL,
	`admin_clinic_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_admin_clinic_id` PRIMARY KEY 
(
	`admin_clinic_id` ASC
) 
);

/****** Object:  Table [dbo].[ApplicationRole]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE ApplicationRole(
	`role_code` nvarchar(60) NOT NULL,
	`role_name` nvarchar(30) NOT NULL,
	`role_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_role_id` PRIMARY KEY 
(
	`role_id` ASC
) 
);

/****** Object:  Table [dbo].[Bill]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Bill(
	`Amount` decimal(10, 2) NULL,
	`payment_type` varchar(25) NULL,
	`BillId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_bill_id` PRIMARY KEY 
(
	`BillId` ASC
) 
);

/****** Object:  Table [dbo].[BillPayment]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE BillPayment(
	`BillId` int NOT NULL,
	`ReceptionistID` int NULL,
	`PatientId` int NULL,
	`VisitId` int NOT NULL,
	`DateOfPayment` Datetime(6) NULL,
	`Billed` Tinyint NOT NULL,
	`BillPaymentId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_bill_payment_id` PRIMARY KEY 
(
	`BillPaymentId` ASC
) 
);

/****** Object:  Table [dbo].[BookAppointment]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE BookAppointment(
	`ScheduleId` int NOT NULL,
	`PatientId` int NOT NULL,
	`DateBooked` date NULL,
	`TimeBooked` time(6) NULL,
	`status` varchar(20) NULL,
	`book_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_bookAppontment_id` PRIMARY KEY 
(
	`book_id` ASC
) 
);

/****** Object:  Table [dbo].[City]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE City(
	`city_name` nvarchar(256) NOT NULL,
	`city_id` int AUTO_INCREMENT NOT NULL,
	`country_id` int NOT NULL,
	`zip_code` int NULL,
 CONSTRAINT `PK_city_id` PRIMARY KEY 
(
	`city_id` ASC
) 
);

/****** Object:  Table [dbo].[Contact]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Contact(
	`PersonId` int NOT NULL,
	`Type` char(10) NOT NULL,
	`Value` nvarchar(256) NOT NULL,
	`ContactId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_contact_id` PRIMARY KEY 
(
	`ContactId` ASC
) 
);

/****** Object:  Table [dbo].[Country]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Country(
	`country_name` nvarchar(256) NOT NULL,
	`country_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_country_id` PRIMARY KEY 
(
	`country_id` ASC
) 
);

/****** Object:  Table [dbo].[Doctor]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Doctor(
	`PersonId` int NOT NULL,
	`PassCode` nvarchar(256) NOT NULL,
	`DoctorId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_doctor_id` PRIMARY KEY 
(
	`DoctorId` ASC
) 
);

/****** Object:  Table [dbo].[DrugManufacturer]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE DrugManufacturer(
	`name` nvarchar(50) NOT NULL,
	`drug_manufacturer_id` int AUTO_INCREMENT NOT NULL,
	`address_id` int NOT NULL,
 CONSTRAINT `PK_drug_manufacturer_id` PRIMARY KEY 
(
	`drug_manufacturer_id` ASC
) 
);

/****** Object:  Table [dbo].[Education]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Education(
	`InstitutionName` varchar(25) NULL,
	`EucationTypeId` int NOT NULL,
	`EducationProgramId` int NOT NULL,
	`EducationId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_education_id` PRIMARY KEY 
(
	`EducationId` ASC
) 
);

/****** Object:  Table [dbo].[EducationProgram]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE EducationProgram(
	`ProgramName` varchar(50) NOT NULL,
	`EducationProgramId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_education_program_id` PRIMARY KEY 
(
	`EducationProgramId` ASC
) 
);

/****** Object:  Table [dbo].[EducationType]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE EducationType(
	`EducationName` varchar(25) NULL,
	`EducationTypeId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_typet_id` PRIMARY KEY 
(
	`EducationTypeId` ASC
) 
);

/****** Object:  Table [dbo].[Emergency_Information]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Emergency_Information(
	`person_id` int NOT NULL,
	`patient_id` int NOT NULL,
	`emergency_info_id` int NOT NULL,
 CONSTRAINT `PK_emergency_info_id` PRIMARY KEY 
(
	`emergency_info_id` ASC
) 
);

/****** Object:  Table [dbo].[Food]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Food(
	`food_id` int AUTO_INCREMENT NOT NULL,
	`name` nvarchar(40) NOT NULL,
 CONSTRAINT `PK_food_id` PRIMARY KEY 
(
	`food_id` ASC
) 
);

/****** Object:  Table [dbo].[Gender]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Gender(
	`gender_id` int NOT NULL,
	`gender_name` char(7) NOT NULL,
 CONSTRAINT `PK_gender_id` PRIMARY KEY 
(
	`gender_id` ASC
) 
);

/****** Object:  Table [dbo].[GroupRole]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE GroupRole(
	`group_id` int NOT NULL,
	`role_id` int NOT NULL,
	`usr_group_role` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_usr_group_role` PRIMARY KEY 
(
	`usr_group_role` ASC
) 
);

/****** Object:  Table [dbo].[Guardian]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Guardian(
	`ParentID` int NOT NULL,
	`ChildId` int NOT NULL,
	`GuardianId` int NOT NULL,
 CONSTRAINT `PK_guardian_id` PRIMARY KEY 
(
	`GuardianId` ASC
) 
);

/****** Object:  Table [dbo].[HRManager]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE HRManager(
	`PersonId` int NULL,
	`PassCode` nvarchar(256) NOT NULL,
	`ManagerId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_manager_id` PRIMARY KEY 
(
	`ManagerId` ASC
) 
);

/****** Object:  Table [dbo].[InfectiousDisease]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE InfectiousDisease(
	`infectious_disease_id` int AUTO_INCREMENT NOT NULL,
	`name` nvarchar(40) NOT NULL,
 CONSTRAINT `PK_infectious_disease_id` PRIMARY KEY 
(
	`infectious_disease_id` ASC
) 
);

/****** Object:  Table [dbo].[Inventory]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Inventory(
	`medicine_id` int NOT NULL,
	`quantity` int NOT NULL,
	`location_id` int NOT NULL,
	`inventory_type_id` int NOT NULL,
	`date_updated` Datetime(6) NOT NULL,
	`updated_by` int NOT NULL,
	`inventory_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_inventory_id` PRIMARY KEY 
(
	`inventory_id` ASC
) 
);

/****** Object:  Table [dbo].[InventoryArchive]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE InventoryArchive(
	`inventory_id` int NOT NULL,
	`quantity` int NOT NULL,
	`location_id` int NOT NULL,
	`inventory_type_id` int NOT NULL,
	`date_updated` Datetime(6) NOT NULL,
	`updated_by` int NOT NULL,
	`comment` nvarchar(256) NOT NULL,
	`inventory_archive_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_inventory_archive_id` PRIMARY KEY 
(
	`inventory_archive_id` ASC
) 
);

/****** Object:  Table [dbo].[InventoryType]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE InventoryType(
	`inventory_type` nvarchar(50) NOT NULL,
	`inventory_type_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_inventory_type_id` PRIMARY KEY 
(
	`inventory_type_id` ASC
) 
);

/****** Object:  Table [dbo].[LoginGroup]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE LoginGroup(
	`group_name` varchar(25) NOT NULL,
	`description` nvarchar(60) NOT NULL,
	`group_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_group_id` PRIMARY KEY 
(
	`group_id` ASC
) 
);

/****** Object:  Table [dbo].[MartialStatus]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE MartialStatus(
	`MartialStatusId` int NOT NULL,
	`MartialStatusName` varchar(10) NOT NULL,
 CONSTRAINT `PK_martial_status_id` PRIMARY KEY 
(
	`MartialStatusId` ASC
) 
);

/****** Object:  Table [dbo].[Medicine]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Medicine(
	`medicine_name` nvarchar(50) NOT NULL,
	`package_type` int NOT NULL,
	`weight` int NOT NULL,
	`price` decimal(7, 2) NOT NULL,
	`medicine_id` int AUTO_INCREMENT NOT NULL,
	`manufacturer_id` int NOT NULL,
 CONSTRAINT `PK_medicine_id` PRIMARY KEY 
(
	`medicine_id` ASC
) 
);

/****** Object:  Table [dbo].[MentalHealth]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE MentalHealth(
	`mental_health_id` int AUTO_INCREMENT NOT NULL,
	`name` nvarchar(40) NOT NULL,
 CONSTRAINT `PK_mental_health_id` PRIMARY KEY 
(
	`mental_health_id` ASC
) 
);

/****** Object:  Table [dbo].[Nurse]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Nurse(
	`PersonId` int NOT NULL,
	`PassCode` nvarchar(256) NOT NULL,
	`NurseId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_nurse_id` PRIMARY KEY 
(
	`NurseId` ASC
) 
);

/****** Object:  Table [dbo].[Occupation]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Occupation(
	`occupation_id` int NOT NULL,
	`occupation_name` varchar(30) NULL,
 CONSTRAINT `PK_occupation_id` PRIMARY KEY 
(
	`occupation_id` ASC
) 
);

/****** Object:  Table [dbo].[Order]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE `Order`(
	`patient_id` int NOT NULL,
	`pharmacist_id` int NOT NULL,
	`prescription_id` int NOT NULL,
	`date_ordered` Datetime(6) NOT NULL,
	`order_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_order_id` PRIMARY KEY 
(
	`order_id` ASC
) 
);

/****** Object:  Table [dbo].[OrderItem]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE OrderItem(
	`medicine_id` int NOT NULL,
	`order_id` int NOT NULL,
	`order_item_id` int AUTO_INCREMENT NOT NULL,
	`item_quantity` int NOT NULL,
 CONSTRAINT `PK_order_item_id` PRIMARY KEY 
(
	`order_item_id` ASC
) 
);

/****** Object:  Table [dbo].[PackageType]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PackageType(
	`name` nvarchar(30) NULL,
	`package_type_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_package_type_id` PRIMARY KEY 
(
	`package_type_id` ASC
) 
);

/****** Object:  Table [dbo].[Patient]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Patient(
	`person_id` int NOT NULL,
	`pass_code` nvarchar(256) NOT NULL,
	`patient_id` int AUTO_INCREMENT NOT NULL,
	`occupation_id` int NOT NULL,
 CONSTRAINT `PK_patient_id` PRIMARY KEY 
(
	`patient_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientFoodAllergylHX]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientFoodAllergylHX(
	`patient_food_allergy_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`food_id` int NOT NULL,
	`date_taken` Datetime(6) NOT NULL,
 CONSTRAINT `PK_patient_food_allergy_id` PRIMARY KEY 
(
	`patient_food_allergy_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientInfectiousDiseaseHX]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientInfectiousDiseaseHX(
	`patient_infectious_disease_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`infectious_disease_id` int NOT NULL,
	`date_taken` Datetime(6) NOT NULL,
 CONSTRAINT `PK_patient_infectious_disease_id` PRIMARY KEY 
(
	`patient_infectious_disease_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientMedicineAllergy]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientMedicineAllergy(
	`medicine_id` int NOT NULL,
	`date_of_onset` Datetime(6) NOT NULL,
	`alergie_id` int NOT NULL,
	`patient_id` int NOT NULL,
 CONSTRAINT `PK_alergie_id` PRIMARY KEY 
(
	`alergie_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientMentalHealthHX]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientMentalHealthHX(
	`patient_mental_health_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`mental_health_id` int NOT NULL,
	`date_taken` Datetime(6) NOT NULL,
 CONSTRAINT `PK_patient_mental_health_id` PRIMARY KEY 
(
	`patient_mental_health_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientRelative]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientRelative(
	`patient_relative_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`relative_id` int NOT NULL,
	`relative_type_id` int NOT NULL,
 CONSTRAINT `PK_patient_relative_id` PRIMARY KEY 
(
	`patient_relative_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientSkinHX]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientSkinHX(
	`patient_skin_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`skin_id` int NOT NULL,
	`date_taken` Datetime(6) NOT NULL,
 CONSTRAINT `PK_patient_skin_id` PRIMARY KEY 
(
	`patient_skin_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientSurgicalHX]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientSurgicalHX(
	`patient_surgical_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`surgical_id` int NOT NULL,
	`date_taken` Datetime(6) NOT NULL,
 CONSTRAINT `PK_patient_surgical_id` PRIMARY KEY 
(
	`patient_surgical_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientVaccineHX]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientVaccineHX(
	`patient_vaccine_hx_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`vaccine_id` int NOT NULL,
	`date_taken` Datetime(6) NOT NULL,
 CONSTRAINT `PK_patient_vaccine_hx_id` PRIMARY KEY 
(
	`patient_vaccine_hx_id` ASC
) 
);

/****** Object:  Table [dbo].[PatientVitalHX]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PatientVitalHX(
	`patient_vital_hx_id` int AUTO_INCREMENT NOT NULL,
	`patient_id` int NOT NULL,
	`vital_id` int NOT NULL,
	`date_taken` Datetime(6) NOT NULL,
 CONSTRAINT `PK_patient_vital_hx_id` PRIMARY KEY 
(
	`patient_vital_hx_id` ASC
) 
);

/****** Object:  Table [dbo].[Person]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Person(
	`PersonId` int NOT NULL,
	`FirstName` varchar(40) NOT NULL,
	`MiddleName` varchar(40) NULL,
	`LastName` varchar(40) NOT NULL,
	`DateOfBirth` date NULL,
	`ReigionId` int NOT NULL,
	`GenderId` int NOT NULL,
	`MartialStatusId` int NOT NULL,
	`BirthCityId` int NOT NULL,
	`AddressId` int NOT NULL,
 CONSTRAINT `PK_person_id` PRIMARY KEY 
(
	`PersonId` ASC
) 
);

/****** Object:  Table [dbo].[PersonArchive]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PersonArchive(
	`PersonId` int NOT NULL,
	`FirstName` varchar(20) NULL,
	`MiddleName` varchar(20) NULL,
	`LastName` varchar(20) NULL,
	`ReligionId` int NOT NULL,
	`GenderId` int NOT NULL,
	`MartialStatusId` int NOT NULL,
	`AddressId` int NOT NULL,
	`PersonArchiveId` int AUTO_INCREMENT NOT NULL,
	`DateChanged` datetime(3) NOT NULL,
 CONSTRAINT `PK_person_archive_id` PRIMARY KEY 
(
	`PersonArchiveId` ASC
) 
);

/****** Object:  Table [dbo].[PersonEducation]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PersonEducation(
	`PersonId` int NOT NULL,
	`EducationId` int NOT NULL,
	`DateStart` date NULL,
	`DateEnd` date NULL,
	`PersonEducationId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_person_education_id` PRIMARY KEY 
(
	`PersonEducationId` ASC
) 
);

/****** Object:  Table [dbo].[Pharmacist]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Pharmacist(
	`PersonId` int NOT NULL,
	`PassCode` nvarchar(256) NOT NULL,
	`PharmacistId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_pharmacist_id` PRIMARY KEY 
(
	`PharmacistId` ASC
) 
);

/****** Object:  Table [dbo].[Pharmacy_Manager]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Pharmacy_Manager(
	`person_id` int NOT NULL,
	`pass_code` nvarchar(256) NOT NULL,
	`pharmacy_manager_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_pharmacy_manager_id` PRIMARY KEY 
(
	`pharmacy_manager_id` ASC
) 
);

/****** Object:  Table [dbo].[Prescription]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Prescription(
	`comment/desc` nvarchar(256) NOT NULL,
	`prescription_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_prescription_id` PRIMARY KEY 
(
	`prescription_id` ASC
) 
);

/****** Object:  Table [dbo].[PrescriptionMedicines]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE PrescriptionMedicines(
	`PrescriptionId` int NOT NULL,
	`MedicineId` int NOT NULL,
	`DaysToUse` int NOT NULL,
	`times_per_day` int NOT NULL,
	`comment` nvarchar(255) NOT NULL,
	`prescribed_medicine_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_prescribed_medicine_id` PRIMARY KEY 
(
	`prescribed_medicine_id` ASC
) 
);

/****** Object:  Table [dbo].[Receptionist]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Receptionist(
	`PersonId` int NOT NULL,
	`pass_code` nvarchar(256) NOT NULL,
	`receptionist_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_receptionist_id` PRIMARY KEY 
(
	`receptionist_id` ASC
) 
);

/****** Object:  Table [dbo].[RelativeType]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE RelativeType(
	`relative_type_id` int AUTO_INCREMENT NOT NULL,
	`name` nvarchar(40) NOT NULL,
 CONSTRAINT `PK_relative_type_id` PRIMARY KEY 
(
	`relative_type_id` ASC
) 
);

/****** Object:  Table [dbo].[Religion]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Religion(
	`name` varchar(20) NOT NULL,
	`religion_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_religion_id` PRIMARY KEY 
(
	`religion_id` ASC
) 
);

/****** Object:  Table [dbo].[Schedule]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Schedule(
	`DoctorId` int NOT NULL,
	`status` int NOT NULL,
	`DateStart` date NOT NULL,
	`DateEnd` date NOT NULL,
	`TimeStart` time(6) NOT NULL,
	`TimeEnd` time(6) NOT NULL,
	`ManagerId` int NOT NULL,
	`Schedule` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_schedule_id` PRIMARY KEY 
(
	`Schedule` ASC
) 
);

/****** Object:  Table [dbo].[ScheduleStatus]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE ScheduleStatus(
	`ScheduleStatusId` int AUTO_INCREMENT NOT NULL,
	`StatusName` varchar(25) NOT NULL,
 CONSTRAINT `PK_ScheduleStatusId` PRIMARY KEY 
(
	`ScheduleStatusId` ASC
) 
);

/****** Object:  Table [dbo].[Skin]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Skin(
	`skin_id` int AUTO_INCREMENT NOT NULL,
	`name` nvarchar(40) NOT NULL,
 CONSTRAINT `PK_skin_id` PRIMARY KEY 
(
	`skin_id` ASC
) 
);

/****** Object:  Table [dbo].[Surgical]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Surgical(
	`surgical_id` int AUTO_INCREMENT NOT NULL,
	`name` nvarchar(40) NOT NULL,
 CONSTRAINT `PK_surgical_id` PRIMARY KEY 
(
	`surgical_id` ASC
) 
);

/****** Object:  Table [dbo].[UserGroup]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE UserGroup(
	`user_id` int NOT NULL,
	`group_id` int NULL,
	`usr_group_id` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_usr_group_id` PRIMARY KEY 
(
	`usr_group_id` ASC
) 
);

/****** Object:  Table [dbo].[Vaccine]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Vaccine(
	`vaccine_id` int AUTO_INCREMENT NOT NULL,
	`name` nvarchar(40) NOT NULL,
 CONSTRAINT `PK_vaccine_id` PRIMARY KEY 
(
	`vaccine_id` ASC
) 
);

/****** Object:  Table [dbo].[Visit]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Visit(
	`BookId` int NOT NULL,
	`PrescriptionID` int NOT NULL,
	`DateTimeStart` Datetime(6) NOT NULL,
	`DateTimeEnd` Datetime(6) NOT NULL,
	`status` varchar(20) NOT NULL,
	`VisitId` int AUTO_INCREMENT NOT NULL,
 CONSTRAINT `PK_visit_id` PRIMARY KEY 
(
	`VisitId` ASC
) 
);

/****** Object:  Table [dbo].[Vitals]    Script Date: 6/10/2017 2:17:05 AM ******/
/* SET ANSI_NULLS ON */
 
/* SET QUOTED_IDENTIFIER ON */
 
CREATE TABLE Vitals(
	`bp` decimal(5, 2) NOT NULL,
	`hr` decimal(5, 2) NOT NULL,
	`rr` decimal(5, 2) NOT NULL,
	`ht/lt` decimal(5, 2) NOT NULL,
	`wt` decimal(5, 2) NOT NULL,
	`bmi` decimal(5, 2) NOT NULL,
	`vital_id` int NOT NULL,
 CONSTRAINT `PK_vital_id` PRIMARY KEY 
(
	`vital_id` ASC
) 
);


/****** Object:  Index [UQ_City_PostCode_StrName_AppNo_Address]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Address` ADD  CONSTRAINT `UQ_City_PostCode_StrName_AppNo_Address` UNIQUE 
(
	`city_id` ASC,
	`building_number` ASC,
	`street_name` ASC
);


/****** Object:  Index [UQ_Per_Clin_Admin]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `AdminClinic` ADD  CONSTRAINT `UQ_Per_Clin_Admin` UNIQUE 
(
	`person_id` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_RoleName_RoleCode]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `ApplicationRole` ADD  CONSTRAINT `UQ_RoleName_RoleCode` UNIQUE 
(
	`role_code` ASC,
	`role_name` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Amount_PaymentType_Bill]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Bill` ADD  CONSTRAINT `UQ_Amount_PaymentType_Bill` UNIQUE 
(
	`Amount` ASC,
	`payment_type` ASC
);
/****** Object:  Index [UQ_Visit_BillPayment]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `BillPayment` ADD  CONSTRAINT `UQ_Visit_BillPayment` UNIQUE 
(
	`VisitId` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Schedule_Patient_Status_BookAppointment]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `BookAppointment` ADD  CONSTRAINT `UQ_Schedule_Patient_Status_BookAppointment` UNIQUE 
(
	`ScheduleId` ASC,
	`PatientId` ASC,
	`status` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Per_Contact]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Contact` ADD  CONSTRAINT `UQ_Per_Contact` UNIQUE 
(
	`PersonId` ASC,
	`Value` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_Country]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Country` ADD  CONSTRAINT `UQ_Name_Country` UNIQUE 
(
	`country_name` ASC
);
/****** Object:  Index [UQ_Per_Doc]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Doctor` ADD  CONSTRAINT `UQ_Per_Doc` UNIQUE 
(
	`PersonId` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_DrugManufacturer]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `DrugManufacturer` ADD  CONSTRAINT `UQ_Name_DrugManufacturer` UNIQUE 
(
	`name` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_EducationType_EducationProgram_Education]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Education` ADD  CONSTRAINT `UQ_EducationType_EducationProgram_Education` UNIQUE 
(
	`EucationTypeId` ASC,
	`EducationProgramId` ASC,
	`InstitutionName` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_EducationProgram]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `EducationProgram` ADD  CONSTRAINT `UQ_Name_EducationProgram` UNIQUE 
(
	`ProgramName` ASC
);
/****** Object:  Index [UQ_Person_Patient_EmergencyContact]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Emergency_Information` ADD  CONSTRAINT `UQ_Person_Patient_EmergencyContact` UNIQUE 
(
	`patient_id` ASC,
	`person_id` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_Food]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Food` ADD  CONSTRAINT `UQ_Name_Food` UNIQUE 
(
	`name` ASC
);
/****** Object:  Index [UQ_Role_Group_GroupRole]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `GroupRole` ADD  CONSTRAINT `UQ_Role_Group_GroupRole` UNIQUE 
(
	`group_id` ASC,
	`role_id` ASC
);
/****** Object:  Index [UQ_Person_Child_Guardian]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Guardian` ADD  CONSTRAINT `UQ_Person_Child_Guardian` UNIQUE 
(
	`ParentID` ASC,
	`ChildId` ASC
);
/****** Object:  Index [UQ_Per_HRMan]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `HRManager` ADD  CONSTRAINT `UQ_Per_HRMan` UNIQUE 
(
	`PersonId` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_InfectiousDisease]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `InfectiousDisease` ADD  CONSTRAINT `UQ_Name_InfectiousDisease` UNIQUE 
(
	`name` ASC
);
/****** Object:  Index [UQ_Location_InventoryType_Medicine_Inventory]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Inventory` ADD  CONSTRAINT `UQ_Location_InventoryType_Medicine_Inventory` UNIQUE 
(
	`medicine_id` ASC,
	`location_id` ASC,
	`inventory_type_id` ASC
);
/****** Object:  Index [UQ_Inventory_DateTime_InventoryArchive]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `InventoryArchive` ADD  CONSTRAINT `UQ_Inventory_DateTime_InventoryArchive` UNIQUE 
(
	`inventory_id` ASC,
	`date_updated` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [Uq_InventoryType]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `InventoryType` ADD  CONSTRAINT `Uq_InventoryType` UNIQUE 
(
	`inventory_type` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_Description_LoginGroup]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `LoginGroup` ADD  CONSTRAINT `UQ_Name_Description_LoginGroup` UNIQUE 
(
	`group_name` ASC,
	`description` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_MedName_PackageType_Weight_Manufacturer_Medicine]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Medicine` ADD  CONSTRAINT `UQ_MedName_PackageType_Weight_Manufacturer_Medicine` UNIQUE 
(
	`medicine_name` ASC,
	`package_type` ASC,
	`weight` ASC,
	`manufacturer_id` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_MentalHealth]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `MentalHealth` ADD  CONSTRAINT `UQ_Name_MentalHealth` UNIQUE 
(
	`name` ASC
);
/****** Object:  Index [UQ_Per_Nur]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Nurse` ADD  CONSTRAINT `UQ_Per_Nur` UNIQUE 
(
	`PersonId` ASC
);
/****** Object:  Index [UQ_Patient_Pharmacist_Prescription_Order]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Order` ADD  CONSTRAINT `UQ_Patient_Pharmacist_Prescription_Order` UNIQUE 
(
	`patient_id` ASC,
	`pharmacist_id` ASC,
	`prescription_id` ASC,
	`date_ordered` ASC
);
/****** Object:  Index [UQ_Medicine_Order_OrderItem]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `OrderItem` ADD  CONSTRAINT `UQ_Medicine_Order_OrderItem` UNIQUE 
(
	`medicine_id` ASC,
	`order_id` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_PackageType]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PackageType` ADD  CONSTRAINT `UQ_Name_PackageType` UNIQUE 
(
	`name` ASC
);
/****** Object:  Index [UQ_Per_Pat]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Patient` ADD  CONSTRAINT `UQ_Per_Pat` UNIQUE 
(
	`person_id` ASC
);
/****** Object:  Index [UQ_Patient_Food_PatientFoodAllergylHX]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientFoodAllergylHX` ADD  CONSTRAINT `UQ_Patient_Food_PatientFoodAllergylHX` UNIQUE 
(
	`patient_id` ASC,
	`food_id` ASC
);
/****** Object:  Index [UQ_Patient_InfectiousDisease_dateTaken_PatientInfectiousDiseaseHX]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientInfectiousDiseaseHX` ADD  CONSTRAINT `UQ_Patient_InfectDisease_dateTaken_PatientInfectiousDiseaseHX` UNIQUE 
(
	`patient_id` ASC,
	`infectious_disease_id` ASC,
	`date_taken` ASC
);
/****** Object:  Index [UQ_Medicine_Patient_Alergis]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientMedicineAllergy` ADD  CONSTRAINT `UQ_Medicine_Patient_Alergis` UNIQUE 
(
	`medicine_id` ASC,
	`patient_id` ASC
);
/****** Object:  Index [UQ_Patient_MentalHealth_dateTaken_PatientMentalHealthHX]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientMentalHealthHX` ADD  CONSTRAINT `UQ_Patient_MentalHealth_dateTaken_PatientMentalHealthHX` UNIQUE 
(
	`patient_id` ASC,
	`mental_health_id` ASC,
	`date_taken` ASC
);
/****** Object:  Index [UQ_Patient_Relative_PatientRelative]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientRelative` ADD  CONSTRAINT `UQ_Patient_Relative_PatientRelative` UNIQUE 
(
	`patient_id` ASC,
	`relative_id` ASC
);
/****** Object:  Index [UQ_Patient_Skin_dateTaken_PatientSkinHX]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientSkinHX` ADD  CONSTRAINT `UQ_Patient_Skin_dateTaken_PatientSkinHX` UNIQUE 
(
	`patient_id` ASC,
	`skin_id` ASC,
	`date_taken` ASC
);
/****** Object:  Index [UQ_Patient_Surgical_dateTaken_PatientSurgicalHX]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientSurgicalHX` ADD  CONSTRAINT `UQ_Patient_Surgical_dateTaken_PatientSurgicalHX` UNIQUE 
(
	`patient_id` ASC,
	`surgical_id` ASC,
	`date_taken` ASC
);
/****** Object:  Index [UQ_Patient_Vaccine_dateTaken_PatientVaccineHX]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientVaccineHX` ADD  CONSTRAINT `UQ_Patient_Vaccine_dateTaken_PatientVaccineHX` UNIQUE 
(
	`patient_id` ASC,
	`vaccine_id` ASC,
	`date_taken` ASC
);
/****** Object:  Index [UQ_Patient_Vital_dateTaken_PatientVitalHX]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PatientVitalHX` ADD  CONSTRAINT `UQ_Patient_Vital_dateTaken_PatientVitalHX` UNIQUE 
(
	`patient_id` ASC,
	`vital_id` ASC,
	`date_taken` ASC
);
/****** Object:  Index [UQ_Gender_Religio_Person_MartStat_Address_DateCh_PersonArchive]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PersonArchive` ADD  CONSTRAINT `UQ_Gender_Religio_Person_MartStat_Address_DateCh_PersonArchive` UNIQUE 
(
	`PersonId` ASC,
	`ReligionId` ASC,
	`GenderId` ASC,
	`DateChanged` ASC,
	`AddressId` ASC,
	`MartialStatusId` ASC
);
/****** Object:  Index [UQ_Education_Person_PersonEducation]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PersonEducation` ADD  CONSTRAINT `UQ_Education_Person_PersonEducation` UNIQUE 
(
	`EducationId` ASC,
	`PersonId` ASC
);
/****** Object:  Index [UQ_Per_Phar]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Pharmacist` ADD  CONSTRAINT `UQ_Per_Phar` UNIQUE 
(
	`PersonId` ASC
);
/****** Object:  Index [UQ_Per_Phar_Man]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Pharmacy_Manager` ADD  CONSTRAINT `UQ_Per_Phar_Man` UNIQUE 
(
	`person_id` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Comment_Prescription]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Prescription` ADD  CONSTRAINT `UQ_Comment_Prescription` UNIQUE 
(
	`comment/desc` ASC
);
/****** Object:  Index [UQ_Medicine_Prescription_PrescriptionMedicines]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `PrescriptionMedicines` ADD  CONSTRAINT `UQ_Medicine_Prescription_PrescriptionMedicines` UNIQUE 
(
	`MedicineId` ASC,
	`PrescriptionId` ASC
);
/****** Object:  Index [UQ_Per_Rec]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Receptionist` ADD  CONSTRAINT `UQ_Per_Rec` UNIQUE 
(
	`PersonId` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_FamilyRelativeType]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `RelativeType` ADD  CONSTRAINT `UQ_Name_FamilyRelativeType` UNIQUE 
(
	`name` ASC
);
/****** Object:  Index [UQ_Doc_Man_Schedule_date_time]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Schedule` ADD  CONSTRAINT `UQ_Doc_Man_Schedule_date_time` UNIQUE 
(
	`status` ASC,
	`ManagerId` ASC,
	`DoctorId` ASC,
	`DateStart` ASC,
	`DateEnd` ASC,
	`TimeStart` ASC,
	`TimeEnd` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_StatusName_ScheduleStatus]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `ScheduleStatus` ADD  CONSTRAINT `UQ_StatusName_ScheduleStatus` UNIQUE 
(
	`StatusName` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_Skin]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Skin` ADD  CONSTRAINT `UQ_Name_Skin` UNIQUE 
(
	`name` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_Surgical]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Surgical` ADD  CONSTRAINT `UQ_Name_Surgical` UNIQUE 
(
	`name` ASC
);
/****** Object:  Index [UQ_User_Group_UserGroup]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `UserGroup` ADD  CONSTRAINT `UQ_User_Group_UserGroup` UNIQUE 
(
	`user_id` ASC,
	`group_id` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Name_Vaccine]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Vaccine` ADD  CONSTRAINT `UQ_Name_Vaccine` UNIQUE 
(
	`name` ASC
);
/* SET ANSI_PADDING ON */

 
/****** Object:  Index [UQ_Book_Status_Visit]    Script Date: 6/10/2017 2:17:05 AM ******/
ALTER TABLE `Visit` ADD  CONSTRAINT `UQ_Book_Status_Visit` UNIQUE 
(
	`BookId` ASC,
	`status` ASC
);

ALTER TABLE `Address`  ADD  CONSTRAINT `FK_City_Address` FOREIGN KEY(`city_id`)
REFERENCES `City`(`city_id`);
ALTER TABLE `AdminClinic`ADD  CONSTRAINT `FK_Per_Clin_Admin` FOREIGN KEY(`person_id`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `BillPayment`ADD  CONSTRAINT `FK_Bill_BillPayment` FOREIGN KEY(`BillId`)
REFERENCES `Bill`(`BillId`); 
ALTER TABLE `BillPayment`ADD  CONSTRAINT `FK_Patient_BillPayment` FOREIGN KEY(`PatientId`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `BillPayment`ADD  CONSTRAINT `FK_Receptionist_BillPayment` FOREIGN KEY(`ReceptionistID`)
REFERENCES `Receptionist`(`receptionist_id`); 
ALTER TABLE `BillPayment`ADD  CONSTRAINT `FK_Visit_BillPayment` FOREIGN KEY(`VisitId`)
REFERENCES `Visit`(`VisitId`); 
ALTER TABLE `BookAppointment`ADD  CONSTRAINT `FK_Patient_BookAppointment` FOREIGN KEY(`PatientId`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `BookAppointment`ADD  CONSTRAINT `FK_Schedule_BookAppointment` FOREIGN KEY(`ScheduleId`)
REFERENCES `Schedule`(`Schedule`); 
ALTER TABLE `City`ADD  CONSTRAINT `FK_Country_City` FOREIGN KEY(`country_id`)
REFERENCES `Country`(`country_id`); 
ALTER TABLE `Contact`ADD  CONSTRAINT `FK_Per_Contact` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `Doctor`ADD  CONSTRAINT `FK_Per_Doc` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `DrugManufacturer`ADD  CONSTRAINT `FK_Address_DrugManufacturer` FOREIGN KEY(`address_id`)
REFERENCES `Address`(`address_id`); 
ALTER TABLE `Education`ADD  CONSTRAINT `FK_EducationProgram_Education` FOREIGN KEY(`EducationProgramId`)
REFERENCES `EducationProgram`(`EducationProgramId`); 
ALTER TABLE `Education`ADD  CONSTRAINT `FK_EducationType_Education` FOREIGN KEY(`EucationTypeId`)
REFERENCES `EducationType`(`EducationTypeId`); 
ALTER TABLE `Emergency_Information`ADD  CONSTRAINT `FK_Patient_EmergencyContact` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `Emergency_Information`ADD  CONSTRAINT `FK_Person_EmergencyContact` FOREIGN KEY(`person_id`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `GroupRole`ADD  CONSTRAINT `FK_Group_GroupRole` FOREIGN KEY(`group_id`)
REFERENCES `LoginGroup`(`group_id`); 
ALTER TABLE `GroupRole`ADD  CONSTRAINT `FK_Role_GroupRole` FOREIGN KEY(`role_id`)
REFERENCES `ApplicationRole`(`role_id`); 
ALTER TABLE `Guardian`ADD  CONSTRAINT `FK_child_Guardian` FOREIGN KEY(`ChildId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `Guardian`ADD  CONSTRAINT `FK_Patient_Guardian` FOREIGN KEY(`ParentID`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `HRManager`ADD  CONSTRAINT `FK_Per_HRMan` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `Inventory`ADD  CONSTRAINT `FK_InventoryType_Inventory` FOREIGN KEY(`inventory_type_id`)
REFERENCES `InventoryType`(`inventory_type_id`); 
ALTER TABLE `Inventory`ADD  CONSTRAINT `FK_Location_Inventory` FOREIGN KEY(`location_id`)
REFERENCES `Address`(`address_id`); 
ALTER TABLE `Inventory`ADD  CONSTRAINT `FK_Medicine_Inventory` FOREIGN KEY(`medicine_id`)
REFERENCES `Medicine`(`medicine_id`); 
ALTER TABLE `Inventory`ADD  CONSTRAINT `FK_PharManager_Inventory` FOREIGN KEY(`updated_by`)
REFERENCES `Pharmacy_Manager`(`pharmacy_manager_id`); 
ALTER TABLE `InventoryArchive`ADD  CONSTRAINT `FK_Inventory_InventoryArchive` FOREIGN KEY(`inventory_id`)
REFERENCES `Inventory`(`inventory_id`); 
ALTER TABLE `InventoryArchive`ADD  CONSTRAINT `FK_InventoryType_InventoryArchive` FOREIGN KEY(`inventory_type_id`)
REFERENCES `InventoryType`(`inventory_type_id`); 
ALTER TABLE `InventoryArchive`ADD  CONSTRAINT `FK_Location_InventoryArchive` FOREIGN KEY(`location_id`)
REFERENCES `Address`(`address_id`); 
ALTER TABLE `InventoryArchive`ADD  CONSTRAINT `FK_PharManager_InventoryArchive` FOREIGN KEY(`updated_by`)
REFERENCES `Pharmacy_Manager`(`pharmacy_manager_id`); 
ALTER TABLE `Medicine`ADD  CONSTRAINT `FK_DrugManufacturer_Medicine` FOREIGN KEY(`manufacturer_id`)
REFERENCES `DrugManufacturer`(`drug_manufacturer_id`); 
ALTER TABLE `Medicine`ADD  CONSTRAINT `FK_PackageType_Medicine` FOREIGN KEY(`package_type`)
REFERENCES `PackageType`(`package_type_id`); 
ALTER TABLE `Nurse`ADD  CONSTRAINT `FK_Per_Nur` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `Order`ADD  CONSTRAINT `FK_Patient_Orders` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `Order`ADD  CONSTRAINT `FK_Pharmacist_Orders` FOREIGN KEY(`pharmacist_id`)
REFERENCES `Pharmacist`(`PharmacistId`); 
ALTER TABLE `Order`ADD  CONSTRAINT `FK_Prescription_Orders` FOREIGN KEY(`prescription_id`)
REFERENCES `Prescription`(`prescription_id`); 
ALTER TABLE `OrderItem`ADD  CONSTRAINT `FK_Inventory_OrderItem` FOREIGN KEY(`medicine_id`)
REFERENCES `Inventory`(`inventory_id`); 
ALTER TABLE `OrderItem`ADD  CONSTRAINT `FK_Order_OrderItem` FOREIGN KEY(`order_id`)
REFERENCES `Order`(`order_id`); 
ALTER TABLE `Patient`ADD  CONSTRAINT `FK_Occupation_Pat` FOREIGN KEY(`occupation_id`)
REFERENCES `Occupation`(`occupation_id`); 
ALTER TABLE `Patient`ADD  CONSTRAINT `FK_Per_Pat` FOREIGN KEY(`person_id`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `PatientFoodAllergylHX`ADD  CONSTRAINT `FK_Food_PatientFoodAllergylHX` FOREIGN KEY(`food_id`)
REFERENCES `Food`(`food_id`); 
ALTER TABLE `PatientFoodAllergylHX`ADD  CONSTRAINT `FK_Patient_PatientFoodAllergylHX` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientInfectiousDiseaseHX`ADD  CONSTRAINT `FK_InfectiousDisease_PatientVaccineHX` FOREIGN KEY(`infectious_disease_id`)
REFERENCES `InfectiousDisease`(`infectious_disease_id`); 
ALTER TABLE `PatientInfectiousDiseaseHX`ADD  CONSTRAINT `FK_Patient_PatientInfectiousDiseaseHX` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientMedicineAllergy`ADD  CONSTRAINT `FK_Medicine_PatientMedicineAllergy` FOREIGN KEY(`medicine_id`)
REFERENCES `Medicine`(`medicine_id`); 
ALTER TABLE `PatientMedicineAllergy`ADD  CONSTRAINT `FK_Patient_PatientMedicineAllergy` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientMentalHealthHX`ADD  CONSTRAINT `FK_MentalHealth_PatientMentalHealthHX` FOREIGN KEY(`mental_health_id`)
REFERENCES `MentalHealth`(`mental_health_id`); 
ALTER TABLE `PatientMentalHealthHX`ADD  CONSTRAINT `FK_Patient_PatientMentalHealthHX` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientRelative`ADD  CONSTRAINT `FK_Patient_PatientRelative` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientRelative`ADD  CONSTRAINT `FK_Relative_PatientRelative` FOREIGN KEY(`relative_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientRelative`ADD  CONSTRAINT `FK_RelativeType_PatientRelative` FOREIGN KEY(`relative_type_id`)
REFERENCES `RelativeType`(`relative_type_id`); 
ALTER TABLE `PatientSkinHX`ADD  CONSTRAINT `FK_Patient_PatientSkinHX` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientSkinHX`ADD  CONSTRAINT `FK_Skin_PatientSkinHX` FOREIGN KEY(`skin_id`)
REFERENCES `Skin`(`skin_id`); 
ALTER TABLE `PatientSurgicalHX`ADD  CONSTRAINT `FK_Patient_PatientSurgicalHX` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientSurgicalHX`ADD  CONSTRAINT `FK_Surgical_PatientSurgicalHX` FOREIGN KEY(`surgical_id`)
REFERENCES `Surgical`(`surgical_id`); 
ALTER TABLE `PatientVaccineHX`ADD  CONSTRAINT `FK_Patient_PatientVaccineHX` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientVaccineHX`ADD  CONSTRAINT `FK_Vaccine_PatientVaccineHX` FOREIGN KEY(`vaccine_id`)
REFERENCES `Vaccine`(`vaccine_id`); 
ALTER TABLE `PatientVitalHX`ADD  CONSTRAINT `FK_Patient_PatientVitalHX` FOREIGN KEY(`patient_id`)
REFERENCES `Patient`(`patient_id`); 
ALTER TABLE `PatientVitalHX`ADD  CONSTRAINT `FK_Vital_PatientVitalHX` FOREIGN KEY(`vital_id`)
REFERENCES `Vitals`(`vital_id`); 
ALTER TABLE `Person`ADD  CONSTRAINT `FK_Address_Per` FOREIGN KEY(`AddressId`)
REFERENCES `Address`(`address_id`); 
ALTER TABLE `Person`ADD  CONSTRAINT `FK_BirthCity_Per` FOREIGN KEY(`BirthCityId`)
REFERENCES `City`(`city_id`); 
ALTER TABLE `Person`ADD  CONSTRAINT `FK_Gender_Per` FOREIGN KEY(`GenderId`)
REFERENCES `Gender`(`gender_id`); 
ALTER TABLE `Person`ADD  CONSTRAINT `FK_MartialStatus_Per` FOREIGN KEY(`MartialStatusId`)
REFERENCES `MartialStatus`(`MartialStatusId`); 
ALTER TABLE `Person`ADD  CONSTRAINT `FK_Religion_Per` FOREIGN KEY(`ReigionId`)
REFERENCES `Religion`(`religion_id`); 
ALTER TABLE `PersonArchive`ADD  CONSTRAINT `FK_Person_PersonArchive` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `PersonEducation`ADD  CONSTRAINT `FK_Education_PersonEducation` FOREIGN KEY(`EducationId`)
REFERENCES `Education`(`EducationId`); 
ALTER TABLE `PersonEducation`ADD  CONSTRAINT `FK_Person_PersonEducation` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `Pharmacist`ADD  CONSTRAINT `FK_Per_Phar` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `Pharmacy_Manager`ADD  CONSTRAINT `FK_Per_Phar_Man` FOREIGN KEY(`person_id`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `PrescriptionMedicines`ADD  CONSTRAINT `FK_Medicine_PrescriptionMedicines` FOREIGN KEY(`MedicineId`)
REFERENCES `Medicine`(`medicine_id`); 
ALTER TABLE `PrescriptionMedicines`ADD  CONSTRAINT `FK_Prescription_PrescriptionMedicines` FOREIGN KEY(`PrescriptionId`)
REFERENCES `Prescription`(`prescription_id`); 
ALTER TABLE `Receptionist`ADD  CONSTRAINT `FK_Per_Rec` FOREIGN KEY(`PersonId`)
REFERENCES `Person`(`PersonId`); 
ALTER TABLE `Schedule`ADD  CONSTRAINT `FK_Doc_Schedule` FOREIGN KEY(`DoctorId`)
REFERENCES `Doctor`(`DoctorId`); 
ALTER TABLE `Schedule`ADD  CONSTRAINT `FK_Man_Schedule` FOREIGN KEY(`ManagerId`)
REFERENCES `HRManager`(`ManagerId`); 
ALTER TABLE `Schedule`ADD  CONSTRAINT `FK_ScheduleStatus_Schedule` FOREIGN KEY(`status`)
REFERENCES `ScheduleStatus`(`ScheduleStatusId`); 
ALTER TABLE `UserGroup`ADD  CONSTRAINT `FK_Group_UserGroup` FOREIGN KEY(`group_id`)
REFERENCES `LoginGroup`(`group_id`); 
ALTER TABLE `Visit`ADD  CONSTRAINT `FK_BookAppointment_Visit` FOREIGN KEY(`BookId`)
REFERENCES `BookAppointment`(`book_id`); 
ALTER TABLE `Visit`ADD  CONSTRAINT `FK_Prescription_Visit` FOREIGN KEY(`PrescriptionID`)
REFERENCES `Prescription`(`prescription_id`); 