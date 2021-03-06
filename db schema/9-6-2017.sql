USE [master]
GO
/****** Object:  Database [Clinic]    Script Date: 6/9/2017 2:31:38 AM ******/
CREATE DATABASE [Clinic]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Clinic', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Clinic.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Clinic_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Clinic_log.ldf' , SIZE = 1280KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Clinic] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Clinic].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Clinic] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Clinic] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Clinic] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Clinic] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Clinic] SET ARITHABORT OFF 
GO
ALTER DATABASE [Clinic] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Clinic] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Clinic] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Clinic] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Clinic] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Clinic] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Clinic] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Clinic] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Clinic] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Clinic] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Clinic] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Clinic] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Clinic] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Clinic] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Clinic] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Clinic] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Clinic] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Clinic] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Clinic] SET  MULTI_USER 
GO
ALTER DATABASE [Clinic] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Clinic] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Clinic] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Clinic] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Clinic]
GO
/****** Object:  User [Clinic]    Script Date: 6/9/2017 2:31:38 AM ******/
CREATE USER [Clinic] FOR LOGIN [Clinic] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [Clinic]
GO
/****** Object:  Table [dbo].[Address]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Address](
	[city_id] [int] NOT NULL,
	[building_number] [int] NOT NULL,
	[street_name] [nvarchar](256) NOT NULL,
	[address_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_address_id] PRIMARY KEY CLUSTERED 
(
	[address_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AdminClinic]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AdminClinic](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[admin_clinic_id] [int] IDENTITY(50500000,1) NOT NULL,
 CONSTRAINT [PK_admin_clinic_id] PRIMARY KEY CLUSTERED 
(
	[admin_clinic_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ApplicationRole]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ApplicationRole](
	[role_code] [nvarchar](60) NOT NULL,
	[role_name] [nvarchar](30) NOT NULL,
	[role_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_role_id] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Bill]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[Amount] [decimal](10, 2) NULL,
	[payment_type] [varchar](25) NULL,
	[BillId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_bill_id] PRIMARY KEY CLUSTERED 
(
	[BillId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BillPayment]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillPayment](
	[BillId] [int] NOT NULL,
	[ReceptionistID] [int] NULL,
	[PatientId] [int] NULL,
	[VisitId] [int] NOT NULL,
	[DateOfPayment] [datetime2](7) NULL,
	[Billed] [bit] NOT NULL,
	[BillPaymentId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_bill_payment_id] PRIMARY KEY CLUSTERED 
(
	[BillPaymentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookAppointment]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookAppointment](
	[ScheduleId] [int] NOT NULL,
	[PatientId] [int] NOT NULL,
	[DateBooked] [date] NULL,
	[TimeBooked] [time](7) NULL,
	[status] [varchar](20) NULL,
	[book_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_bookAppontment_id] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[City]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[City](
	[city_name] [nvarchar](256) NOT NULL,
	[city_id] [int] IDENTITY(1,1) NOT NULL,
	[country_id] [int] NOT NULL,
	[zip_code] [int] NULL,
 CONSTRAINT [PK_city_id] PRIMARY KEY CLUSTERED 
(
	[city_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Contact]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[PersonId] [int] NOT NULL,
	[Type] [char](10) NOT NULL,
	[Value] [nvarchar](256) NOT NULL,
	[ContactId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_contact_id] PRIMARY KEY CLUSTERED 
(
	[ContactId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Country]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Country](
	[country_name] [nvarchar](256) NOT NULL,
	[country_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_country_id] PRIMARY KEY CLUSTERED 
(
	[country_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Doctor]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctor](
	[PersonId] [int] NOT NULL,
	[PassCode] [nvarchar](256) NOT NULL,
	[DoctorId] [int] IDENTITY(50000000,1) NOT NULL,
 CONSTRAINT [PK_doctor_id] PRIMARY KEY CLUSTERED 
(
	[DoctorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DrugManufacturer]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DrugManufacturer](
	[name] [nvarchar](50) NOT NULL,
	[drug_manufacturer_id] [int] IDENTITY(1,1) NOT NULL,
	[address_id] [int] NOT NULL,
 CONSTRAINT [PK_drug_manufacturer_id] PRIMARY KEY CLUSTERED 
(
	[drug_manufacturer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Education]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Education](
	[InstitutionName] [varchar](25) NULL,
	[EucationTypeId] [int] NOT NULL,
	[EducationProgramId] [int] NOT NULL,
	[EducationId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_education_id] PRIMARY KEY CLUSTERED 
(
	[EducationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EducationProgram]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EducationProgram](
	[ProgramName] [varchar](50) NOT NULL,
	[EducationProgramId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_education_program_id] PRIMARY KEY CLUSTERED 
(
	[EducationProgramId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EducationType]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EducationType](
	[EducationName] [varchar](25) NULL,
	[EducationTypeId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_typet_id] PRIMARY KEY CLUSTERED 
(
	[EducationTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Emergency_Information]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Emergency_Information](
	[person_id] [int] NOT NULL,
	[patient_id] [int] NOT NULL,
	[emergency_info_id] [int] NOT NULL,
 CONSTRAINT [PK_emergency_info_id] PRIMARY KEY CLUSTERED 
(
	[emergency_info_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Food]    Script Date: 6/9/2017 2:31:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Food](
	[food_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
 CONSTRAINT [PK_food_id] PRIMARY KEY CLUSTERED 
(
	[food_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Gender]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gender](
	[gender_id] [int] NOT NULL,
	[gender_name] [char](7) NOT NULL,
 CONSTRAINT [PK_gender_id] PRIMARY KEY CLUSTERED 
(
	[gender_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[GroupRole]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupRole](
	[group_id] [int] NOT NULL,
	[role_id] [int] NOT NULL,
	[usr_group_role] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_usr_group_role] PRIMARY KEY CLUSTERED 
(
	[usr_group_role] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Guardian]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Guardian](
	[ParentID] [int] NOT NULL,
	[ChildId] [int] NOT NULL,
	[GuardianId] [int] NOT NULL,
 CONSTRAINT [PK_guardian_id] PRIMARY KEY CLUSTERED 
(
	[GuardianId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HRManager]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HRManager](
	[PersonId] [int] NULL,
	[PassCode] [nvarchar](256) NOT NULL,
	[ManagerId] [int] IDENTITY(50700000,1) NOT NULL,
 CONSTRAINT [PK_manager_id] PRIMARY KEY CLUSTERED 
(
	[ManagerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[InfectiousDisease]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InfectiousDisease](
	[infectious_disease_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
 CONSTRAINT [PK_infectious_disease_id] PRIMARY KEY CLUSTERED 
(
	[infectious_disease_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Inventory]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inventory](
	[medicine_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[location_id] [int] NOT NULL,
	[inventory_type_id] [int] NOT NULL,
	[date_updated] [datetime2](7) NOT NULL,
	[updated_by] [int] NOT NULL,
	[inventory_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_inventory_id] PRIMARY KEY CLUSTERED 
(
	[inventory_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[InventoryArchive]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InventoryArchive](
	[inventory_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[location_id] [int] NOT NULL,
	[inventory_type_id] [int] NOT NULL,
	[date_updated] [datetime2](7) NOT NULL,
	[updated_by] [int] NOT NULL,
	[comment] [nvarchar](256) NOT NULL,
	[inventory_archive_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_inventory_archive_id] PRIMARY KEY CLUSTERED 
(
	[inventory_archive_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[InventoryType]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InventoryType](
	[inventory_type] [nvarchar](50) NOT NULL,
	[inventory_type_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_inventory_type_id] PRIMARY KEY CLUSTERED 
(
	[inventory_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoginGroup]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoginGroup](
	[group_name] [varchar](25) NOT NULL,
	[description] [nvarchar](60) NOT NULL,
	[group_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_group_id] PRIMARY KEY CLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MartialStatus]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MartialStatus](
	[MartialStatusId] [int] NOT NULL,
	[MartialStatusName] [varchar](10) NOT NULL,
 CONSTRAINT [PK_martial_status_id] PRIMARY KEY CLUSTERED 
(
	[MartialStatusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Medicine]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicine](
	[medicine_name] [nvarchar](50) NOT NULL,
	[package_type] [int] NOT NULL,
	[weight] [int] NOT NULL,
	[price] [decimal](7, 2) NOT NULL,
	[medicine_id] [int] IDENTITY(1,1) NOT NULL,
	[manufacturer_id] [int] NOT NULL,
 CONSTRAINT [PK_medicine_id] PRIMARY KEY CLUSTERED 
(
	[medicine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MentalHealth]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MentalHealth](
	[mental_health_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
 CONSTRAINT [PK_mental_health_id] PRIMARY KEY CLUSTERED 
(
	[mental_health_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Nurse]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nurse](
	[PersonId] [int] NOT NULL,
	[PassCode] [nvarchar](256) NOT NULL,
	[NurseId] [int] IDENTITY(50100000,1) NOT NULL,
 CONSTRAINT [PK_nurse_id] PRIMARY KEY CLUSTERED 
(
	[NurseId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Occupation]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Occupation](
	[occupation_id] [int] NOT NULL,
	[occupation_name] [varchar](30) NULL,
 CONSTRAINT [PK_occupation_id] PRIMARY KEY CLUSTERED 
(
	[occupation_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Order]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[patient_id] [int] NOT NULL,
	[pharmacist_id] [int] NOT NULL,
	[prescription_id] [int] NOT NULL,
	[date_ordered] [datetime2](7) NOT NULL,
	[order_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_order_id] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderItem]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderItem](
	[medicine_id] [int] NOT NULL,
	[order_id] [int] NOT NULL,
	[order_item_id] [int] IDENTITY(1,1) NOT NULL,
	[item_quantity] [int] NOT NULL,
 CONSTRAINT [PK_order_item_id] PRIMARY KEY CLUSTERED 
(
	[order_item_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PackageType]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PackageType](
	[name] [nvarchar](30) NULL,
	[package_type_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_package_type_id] PRIMARY KEY CLUSTERED 
(
	[package_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Patient]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patient](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[patient_id] [int] IDENTITY(1,1) NOT NULL,
	[occupation_id] [int] NOT NULL,
 CONSTRAINT [PK_patient_id] PRIMARY KEY CLUSTERED 
(
	[patient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientFoodAllergylHX]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientFoodAllergylHX](
	[patient_food_allergy_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[food_id] [int] NOT NULL,
	[date_taken] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_patient_food_allergy_id] PRIMARY KEY CLUSTERED 
(
	[patient_food_allergy_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientInfectiousDiseaseHX]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientInfectiousDiseaseHX](
	[patient_infectious_disease_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[infectious_disease_id] [int] NOT NULL,
	[date_taken] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_patient_infectious_disease_id] PRIMARY KEY CLUSTERED 
(
	[patient_infectious_disease_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientMedicineAllergy]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientMedicineAllergy](
	[medicine_id] [int] NOT NULL,
	[date_of_onset] [datetime2](7) NOT NULL,
	[alergie_id] [int] NOT NULL,
	[patient_id] [int] NOT NULL,
 CONSTRAINT [PK_alergie_id] PRIMARY KEY CLUSTERED 
(
	[alergie_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientMentalHealthHX]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientMentalHealthHX](
	[patient_mental_health_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[mental_health_id] [int] NOT NULL,
	[date_taken] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_patient_mental_health_id] PRIMARY KEY CLUSTERED 
(
	[patient_mental_health_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientRelative]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientRelative](
	[patient_relative_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[relative_id] [int] NOT NULL,
	[relative_type_id] [int] NOT NULL,
 CONSTRAINT [PK_patient_relative_id] PRIMARY KEY CLUSTERED 
(
	[patient_relative_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientSkinHX]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientSkinHX](
	[patient_skin_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[skin_id] [int] NOT NULL,
	[date_taken] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_patient_skin_id] PRIMARY KEY CLUSTERED 
(
	[patient_skin_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientSurgicalHX]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientSurgicalHX](
	[patient_surgical_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[surgical_id] [int] NOT NULL,
	[date_taken] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_patient_surgical_id] PRIMARY KEY CLUSTERED 
(
	[patient_surgical_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientVaccineHX]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientVaccineHX](
	[patient_vaccine_hx_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[vaccine_id] [int] NOT NULL,
	[date_taken] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_patient_vaccine_hx_id] PRIMARY KEY CLUSTERED 
(
	[patient_vaccine_hx_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PatientVitalHX]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientVitalHX](
	[patient_vital_hx_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NOT NULL,
	[vital_id] [int] NOT NULL,
	[date_taken] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_patient_vital_hx_id] PRIMARY KEY CLUSTERED 
(
	[patient_vital_hx_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Person]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Person](
	[PersonId] [int] NOT NULL,
	[FirstName] [varchar](40) NOT NULL,
	[MiddleName] [varchar](40) NULL,
	[LastName] [varchar](40) NOT NULL,
	[DateOfBirth] [date] NULL,
	[ReigionId] [int] NOT NULL,
	[GenderId] [int] NOT NULL,
	[MartialStatusId] [int] NOT NULL,
	[BirthCityId] [int] NOT NULL,
	[AddressId] [int] NOT NULL,
 CONSTRAINT [PK_person_id] PRIMARY KEY CLUSTERED 
(
	[PersonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PersonArchive]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PersonArchive](
	[PersonId] [int] NOT NULL,
	[FirstName] [varchar](20) NULL,
	[MiddleName] [varchar](20) NULL,
	[LastName] [varchar](20) NULL,
	[ReligionId] [int] NOT NULL,
	[GenderId] [int] NOT NULL,
	[MartialStatusId] [int] NOT NULL,
	[AddressId] [int] NOT NULL,
	[PersonArchiveId] [int] IDENTITY(1,1) NOT NULL,
	[DateChanged] [datetime] NOT NULL,
 CONSTRAINT [PK_person_archive_id] PRIMARY KEY CLUSTERED 
(
	[PersonArchiveId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PersonEducation]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PersonEducation](
	[PersonId] [int] NOT NULL,
	[EducationId] [int] NOT NULL,
	[DateStart] [date] NULL,
	[DateEnd] [date] NULL,
	[PersonEducationId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_person_education_id] PRIMARY KEY CLUSTERED 
(
	[PersonEducationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pharmacist]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pharmacist](
	[PersonId] [int] NOT NULL,
	[PassCode] [nvarchar](256) NOT NULL,
	[PharmacistId] [int] IDENTITY(50200000,1) NOT NULL,
 CONSTRAINT [PK_pharmacist_id] PRIMARY KEY CLUSTERED 
(
	[PharmacistId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pharmacy_Manager]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pharmacy_Manager](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[pharmacy_manager_id] [int] IDENTITY(50300000,1) NOT NULL,
 CONSTRAINT [PK_pharmacy_manager_id] PRIMARY KEY CLUSTERED 
(
	[pharmacy_manager_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Prescription]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prescription](
	[comment/desc] [nvarchar](256) NOT NULL,
	[prescription_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_prescription_id] PRIMARY KEY CLUSTERED 
(
	[prescription_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PrescriptionMedicines]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PrescriptionMedicines](
	[PrescriptionId] [int] NOT NULL,
	[MedicineId] [int] NOT NULL,
	[DaysToUse] [int] NOT NULL,
	[times_per_day] [int] NOT NULL,
	[comment] [nvarchar](255) NOT NULL,
	[prescribed_medicine_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_prescribed_medicine_id] PRIMARY KEY CLUSTERED 
(
	[prescribed_medicine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Receptionist]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Receptionist](
	[PersonId] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[receptionist_id] [int] IDENTITY(50400000,1) NOT NULL,
 CONSTRAINT [PK_receptionist_id] PRIMARY KEY CLUSTERED 
(
	[receptionist_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RelativeType]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RelativeType](
	[relative_type_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
 CONSTRAINT [PK_relative_type_id] PRIMARY KEY CLUSTERED 
(
	[relative_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Religion]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Religion](
	[name] [varchar](20) NOT NULL,
	[religion_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_religion_id] PRIMARY KEY CLUSTERED 
(
	[religion_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Schedule]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schedule](
	[DoctorId] [int] NOT NULL,
	[status] [int] NOT NULL,
	[DateStart] [date] NOT NULL,
	[DateEnd] [date] NOT NULL,
	[TimeStart] [time](7) NOT NULL,
	[TimeEnd] [time](7) NOT NULL,
	[ManagerId] [int] NOT NULL,
	[ScheduleId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_schedule_id] PRIMARY KEY CLUSTERED 
(
	[ScheduleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ScheduleStatus]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ScheduleStatus](
	[ScheduleStatusId] [int] IDENTITY(1,1) NOT NULL,
	[StatusName] [varchar](25) NOT NULL,
 CONSTRAINT [PK_ScheduleStatusId] PRIMARY KEY CLUSTERED 
(
	[ScheduleStatusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Skin]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skin](
	[skin_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
 CONSTRAINT [PK_skin_id] PRIMARY KEY CLUSTERED 
(
	[skin_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Surgical]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Surgical](
	[surgical_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
 CONSTRAINT [PK_surgical_id] PRIMARY KEY CLUSTERED 
(
	[surgical_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserGroup]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserGroup](
	[user_id] [int] NOT NULL,
	[group_id] [int] NULL,
	[usr_group_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_usr_group_id] PRIMARY KEY CLUSTERED 
(
	[usr_group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Vaccine]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vaccine](
	[vaccine_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
 CONSTRAINT [PK_vaccine_id] PRIMARY KEY CLUSTERED 
(
	[vaccine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Visit]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Visit](
	[BookId] [int] NOT NULL,
	[PrescriptionID] [int] NOT NULL,
	[DateTimeStart] [datetime2](7) NOT NULL,
	[DateTimeEnd] [datetime2](7) NOT NULL,
	[status] [varchar](20) NOT NULL,
	[VisitId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_visit_id] PRIMARY KEY CLUSTERED 
(
	[VisitId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Vitals]    Script Date: 6/9/2017 2:31:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vitals](
	[bp] [decimal](5, 2) NOT NULL,
	[hr] [decimal](5, 2) NOT NULL,
	[rr] [decimal](5, 2) NOT NULL,
	[ht/lt] [decimal](5, 2) NOT NULL,
	[wt] [decimal](5, 2) NOT NULL,
	[bmi] [decimal](5, 2) NOT NULL,
	[vital_id] [int] NOT NULL,
 CONSTRAINT [PK_vital_id] PRIMARY KEY CLUSTERED 
(
	[vital_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Address] ON 

INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 1, N'sd', 1017)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 3, N'Dardani', 3029)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 7, N'Dardani', 3040)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'adress', 3036)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'as', 1016)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'Dardani', 2025)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'Dragodan', 3028)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'dsd', 1013)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'fdsf', 1019)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'Mitrovica Street', 2023)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'sad', 1014)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'sd', 1020)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12, N'street', 3034)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 13, N'Dardani', 2027)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 13, N'Emshir', 3038)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 13, N'Emshire', 3037)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 15, N'Dardani', 2026)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 21, N'Dardani', 3030)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 21, N'Vranjevc', 2024)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 23, N'df', 1015)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 27, N'King Street', 3032)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 32, N'Dardani', 9)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 32, N'erewr', 1022)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 78, N'dsd', 1010)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 78, N'sd', 1012)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 78, N'sdsd', 1011)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 213, N'Street Name', 5)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 231, N'123123', 2028)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 457, N'sdsd', 1009)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 654, N'new street', 6)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 654, N'not known street', 2022)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 1001, N'Arber', 2)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 1001, N'Mbretresha Teuta', 1)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 1001, N'Street', 3)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 1212, N'1212', 4)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 1212, N'asas', 8)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (1, 12212, N'dfds', 1008)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (3, 7, N'Dardani', 3039)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (3, 12, N'Dardani', 3031)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (3, 654, N'not known street', 3033)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (3, 32101, N'King Street', 7)
INSERT [dbo].[Address] ([city_id], [building_number], [street_name], [address_id]) VALUES (7, 21, N'Dardani', 3035)
SET IDENTITY_INSERT [dbo].[Address] OFF
SET IDENTITY_INSERT [dbo].[AdminClinic] ON 

INSERT [dbo].[AdminClinic] ([person_id], [pass_code], [admin_clinic_id]) VALUES (1234569788, N'e10adc3949ba59abbe56e057f20f883e', 50500000)
SET IDENTITY_INSERT [dbo].[AdminClinic] OFF
SET IDENTITY_INSERT [dbo].[ApplicationRole] ON 

INSERT [dbo].[ApplicationRole] ([role_code], [role_name], [role_id]) VALUES (N'edit_patient', N'Edit', 6)
INSERT [dbo].[ApplicationRole] ([role_code], [role_name], [role_id]) VALUES (N'insert_patient', N'Insert', 5)
SET IDENTITY_INSERT [dbo].[ApplicationRole] OFF
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([Amount], [payment_type], [BillId]) VALUES (CAST(5.00 AS Decimal(10, 2)), N'Cash', 4)
INSERT [dbo].[Bill] ([Amount], [payment_type], [BillId]) VALUES (CAST(5.00 AS Decimal(10, 2)), N'Debit Card', 5)
INSERT [dbo].[Bill] ([Amount], [payment_type], [BillId]) VALUES (CAST(100.00 AS Decimal(10, 2)), N'Cash', 1)
INSERT [dbo].[Bill] ([Amount], [payment_type], [BillId]) VALUES (CAST(100.00 AS Decimal(10, 2)), N'Debit Card', 2)
SET IDENTITY_INSERT [dbo].[Bill] OFF
SET IDENTITY_INSERT [dbo].[BillPayment] ON 

INSERT [dbo].[BillPayment] ([BillId], [ReceptionistID], [PatientId], [VisitId], [DateOfPayment], [Billed], [BillPaymentId]) VALUES (2, 50400000, 1, 4, CAST(N'2017-12-05T00:00:00.0000000' AS DateTime2), 1, 1)
INSERT [dbo].[BillPayment] ([BillId], [ReceptionistID], [PatientId], [VisitId], [DateOfPayment], [Billed], [BillPaymentId]) VALUES (2, 50400000, 1, 7, CAST(N'2017-12-05T00:00:00.0000000' AS DateTime2), 1, 3)
SET IDENTITY_INSERT [dbo].[BillPayment] OFF
SET IDENTITY_INSERT [dbo].[BookAppointment] ON 

INSERT [dbo].[BookAppointment] ([ScheduleId], [PatientId], [DateBooked], [TimeBooked], [status], [book_id]) VALUES (2, 1, CAST(N'2017-05-05' AS Date), CAST(N'12:20:00' AS Time), N'Booked', 7)
INSERT [dbo].[BookAppointment] ([ScheduleId], [PatientId], [DateBooked], [TimeBooked], [status], [book_id]) VALUES (2, 1, CAST(N'2017-05-05' AS Date), CAST(N'12:20:00' AS Time), N'Canceled', 10)
INSERT [dbo].[BookAppointment] ([ScheduleId], [PatientId], [DateBooked], [TimeBooked], [status], [book_id]) VALUES (1002, 1, CAST(N'2017-05-05' AS Date), CAST(N'12:20:00' AS Time), N'Booked', 11)
INSERT [dbo].[BookAppointment] ([ScheduleId], [PatientId], [DateBooked], [TimeBooked], [status], [book_id]) VALUES (1003, 1, CAST(N'2017-05-05' AS Date), CAST(N'12:20:00' AS Time), N'Booked', 12)
INSERT [dbo].[BookAppointment] ([ScheduleId], [PatientId], [DateBooked], [TimeBooked], [status], [book_id]) VALUES (1003, 1, CAST(N'2017-05-05' AS Date), CAST(N'13:20:00' AS Time), N'Canceled', 14)
SET IDENTITY_INSERT [dbo].[BookAppointment] OFF
SET IDENTITY_INSERT [dbo].[City] ON 

INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Prishtina', 1, 1, NULL)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Mitrovica', 2, 1, NULL)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'New York', 3, 2, NULL)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Peja', 4, 1, 10001)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Prizreni', 5, 1, 1001)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Barcelona', 6, 3, 10001)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Melbourne', 7, 4, 1000110)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Amsterdam', 8, 5, 101001)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'Brussels', 9, 6, 1001)
INSERT [dbo].[City] ([city_name], [city_id], [country_id], [zip_code]) VALUES (N'London', 10, 7, 1001)
SET IDENTITY_INSERT [dbo].[City] OFF
SET IDENTITY_INSERT [dbo].[Contact] ON 

INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (1234569788, N'MOB       ', N'049-123-456', 1)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (1234569788, N'MOB       ', N'049-321-564', 2)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999997, N'EMAIL     ', N'ed654@ubt-uni.net', 3)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999997, N'HOME      ', N'6454', 4)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999997, N'WORK      ', N'76544645', 5)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999997, N'MOB       ', N'787878', 6)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999996, N'EMAIL     ', N'ah654@ubt-uni.net', 7)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999996, N'HOME      ', N'879789', 8)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999996, N'WORK      ', N'789879', 9)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999996, N'MOB       ', N'787978', 10)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999994, N'EMAIL     ', N'lavdim.m@ubt-uni.net', 11)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999994, N'HOME      ', N'213123', 12)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999994, N'WORK      ', N'213123213', 13)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999994, N'MOB       ', N'232313', 14)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999993, N'EMAIL     ', N'blerim.z@ubt-uni.net', 15)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999993, N'HOME      ', N'23434', 16)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999993, N'WORK      ', N'234324', 17)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999993, N'MOB       ', N'3434', 18)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999990, N'EMAIL     ', N'ramiz.h@ubt-uni.net', 20)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999990, N'HOME      ', N'213123', 21)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999990, N'WORK      ', N'123123', 22)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999990, N'MOB       ', N'787878', 23)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (213213, N'EMAIL     ', N'email@gmail.com', 24)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (213213, N'HOME      ', N'7878787', 25)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (213213, N'WORK      ', N'787878', 26)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (213213, N'MOB       ', N'237878', 27)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (99999902, N'EMAIL     ', N'yll@ubt-uni.net', 1024)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (99999902, N'HOME      ', N'12121212', 1025)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (99999902, N'WORK      ', N'1212129', 1026)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (12121212, N'EMAIL     ', N'test@ubt-uni.net', 1028)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (12121212, N'HOME      ', N'575757575', 1029)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (12121212, N'WORK      ', N'7575757575', 1030)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (12121212, N'MOB       ', N'8557575', 1031)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999999975, N'EMAIL     ', N'fatos@ubt-uni.net', 1033)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999999975, N'HOME      ', N'12121212', 1034)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999999975, N'WORK      ', N'1212121', 1035)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999999976, N'EMAIL     ', N'besart.pllana@ubt-uni.net', 1037)
INSERT [dbo].[Contact] ([PersonId], [Type], [Value], [ContactId]) VALUES (999999976, N'HOME      ', N'1212121212', 1038)
SET IDENTITY_INSERT [dbo].[Contact] OFF
SET IDENTITY_INSERT [dbo].[Country] ON 

INSERT [dbo].[Country] ([country_name], [country_id]) VALUES (N'Australia', 4)
INSERT [dbo].[Country] ([country_name], [country_id]) VALUES (N'Belgium', 6)
INSERT [dbo].[Country] ([country_name], [country_id]) VALUES (N'Kosovo', 1)
INSERT [dbo].[Country] ([country_name], [country_id]) VALUES (N'Netherland', 5)
INSERT [dbo].[Country] ([country_name], [country_id]) VALUES (N'Spain', 3)
INSERT [dbo].[Country] ([country_name], [country_id]) VALUES (N'United Kingdom', 7)
INSERT [dbo].[Country] ([country_name], [country_id]) VALUES (N'USA', 2)
SET IDENTITY_INSERT [dbo].[Country] OFF
SET IDENTITY_INSERT [dbo].[Doctor] ON 

INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (1234569788, N'e10adc3949ba59abbe56e057f20f883e', 50000000)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (1212, N'1212', 50000001)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (321123, N'12121212', 50000003)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (654321, N'4545454', 50000005)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (3216321, N'123456', 50000006)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (121212, N'asas', 50000007)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (11114111, N'123456', 50000008)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (78787575, N'dfsdf', 50001007)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (4556456, N'12331', 50001008)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (777777, N'e10adc3949ba59abbe56e057f20f883e', 50001009)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (22222222, N'e10adc3949ba59abbe56e057f20f883e', 50001010)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (1111, N'e10adc3949ba59abbe56e057f20f883e', 50001011)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (12222, N'e10adc3949ba59abbe56e057f20f883e', 50001012)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (12111119, N'e10adc3949ba59abbe56e057f20f883e', 50001013)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999999, N'e10adc3949ba59abbe56e057f20f883e', 50001014)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999998, N'e10adc3949ba59abbe56e057f20f883e', 50002014)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999997, N'e10adc3949ba59abbe56e057f20f883e', 50002015)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999996, N'e10adc3949ba59abbe56e057f20f883e', 50002016)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999995, N'e10adc3949ba59abbe56e057f20f883e', 50002017)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999994, N'e10adc3949ba59abbe56e057f20f883e', 50002018)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999993, N'e10adc3949ba59abbe56e057f20f883e', 50002019)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999992, N'e10adc3949ba59abbe56e057f20f883e', 50002020)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999991, N'e10adc3949ba59abbe56e057f20f883e', 50002021)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999990, N'e10adc3949ba59abbe56e057f20f883e', 50002022)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (213213, N'ae6e334f62fb5d989398deed87568c94', 50002023)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (99999902, N'25f9e794323b453885f5181f1b624d0b', 50003023)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (12121212, N'e10adc3949ba59abbe56e057f20f883e', 50003024)
INSERT [dbo].[Doctor] ([PersonId], [PassCode], [DoctorId]) VALUES (999999975, N'e10adc3949ba59abbe56e057f20f883e', 50003027)
SET IDENTITY_INSERT [dbo].[Doctor] OFF
SET IDENTITY_INSERT [dbo].[DrugManufacturer] ON 

INSERT [dbo].[DrugManufacturer] ([name], [drug_manufacturer_id], [address_id]) VALUES (N'PhRMA', 4, 7)
SET IDENTITY_INSERT [dbo].[DrugManufacturer] OFF
SET IDENTITY_INSERT [dbo].[Education] ON 

INSERT [dbo].[Education] ([InstitutionName], [EucationTypeId], [EducationProgramId], [EducationId]) VALUES (N'UBT', 1, 1, 1)
INSERT [dbo].[Education] ([InstitutionName], [EucationTypeId], [EducationProgramId], [EducationId]) VALUES (N'UP', 1, 1, 4)
INSERT [dbo].[Education] ([InstitutionName], [EucationTypeId], [EducationProgramId], [EducationId]) VALUES (N'UBT', 1, 3, 10)
INSERT [dbo].[Education] ([InstitutionName], [EucationTypeId], [EducationProgramId], [EducationId]) VALUES (N'UBT', 1, 5, 7)
INSERT [dbo].[Education] ([InstitutionName], [EucationTypeId], [EducationProgramId], [EducationId]) VALUES (N'UBT', 2, 1, 8)
INSERT [dbo].[Education] ([InstitutionName], [EucationTypeId], [EducationProgramId], [EducationId]) VALUES (N'UBT', 3, 5, 9)
SET IDENTITY_INSERT [dbo].[Education] OFF
SET IDENTITY_INSERT [dbo].[EducationProgram] ON 

INSERT [dbo].[EducationProgram] ([ProgramName], [EducationProgramId]) VALUES (N'Computer Engineering', 5)
INSERT [dbo].[EducationProgram] ([ProgramName], [EducationProgramId]) VALUES (N'Computer Science', 1)
INSERT [dbo].[EducationProgram] ([ProgramName], [EducationProgramId]) VALUES (N'Mathematics', 3)
SET IDENTITY_INSERT [dbo].[EducationProgram] OFF
SET IDENTITY_INSERT [dbo].[EducationType] ON 

INSERT [dbo].[EducationType] ([EducationName], [EducationTypeId]) VALUES (N'BACHELOR', 1)
INSERT [dbo].[EducationType] ([EducationName], [EducationTypeId]) VALUES (N'MASTER', 2)
INSERT [dbo].[EducationType] ([EducationName], [EducationTypeId]) VALUES (N'PHD', 3)
INSERT [dbo].[EducationType] ([EducationName], [EducationTypeId]) VALUES (N'HIGH SCHOOL', 4)
INSERT [dbo].[EducationType] ([EducationName], [EducationTypeId]) VALUES (N'CERTIFICATE', 5)
SET IDENTITY_INSERT [dbo].[EducationType] OFF
INSERT [dbo].[Gender] ([gender_id], [gender_name]) VALUES (1, N'MALE   ')
INSERT [dbo].[Gender] ([gender_id], [gender_name]) VALUES (2, N'FEMALE ')
SET IDENTITY_INSERT [dbo].[GroupRole] ON 

INSERT [dbo].[GroupRole] ([group_id], [role_id], [usr_group_role]) VALUES (1, 6, 6)
SET IDENTITY_INSERT [dbo].[GroupRole] OFF
SET IDENTITY_INSERT [dbo].[HRManager] ON 

INSERT [dbo].[HRManager] ([PersonId], [PassCode], [ManagerId]) VALUES (1234569788, N'123', 50700000)
SET IDENTITY_INSERT [dbo].[HRManager] OFF
SET IDENTITY_INSERT [dbo].[Inventory] ON 

INSERT [dbo].[Inventory] ([medicine_id], [quantity], [location_id], [inventory_type_id], [date_updated], [updated_by], [inventory_id]) VALUES (4, 100, 7, 7, CAST(N'2017-01-05T12:00:00.0000000' AS DateTime2), 50300000, 2)
INSERT [dbo].[Inventory] ([medicine_id], [quantity], [location_id], [inventory_type_id], [date_updated], [updated_by], [inventory_id]) VALUES (4, 50, 7, 4, CAST(N'2017-01-05T12:00:00.0000000' AS DateTime2), 50300000, 5)
INSERT [dbo].[Inventory] ([medicine_id], [quantity], [location_id], [inventory_type_id], [date_updated], [updated_by], [inventory_id]) VALUES (4, 50, 9, 4, CAST(N'2017-01-05T12:00:00.0000000' AS DateTime2), 50300000, 7)
SET IDENTITY_INSERT [dbo].[Inventory] OFF
SET IDENTITY_INSERT [dbo].[InventoryArchive] ON 

INSERT [dbo].[InventoryArchive] ([inventory_id], [quantity], [location_id], [inventory_type_id], [date_updated], [updated_by], [comment], [inventory_archive_id]) VALUES (2, 50, 7, 7, CAST(N'2017-01-05T15:00:00.0000000' AS DateTime2), 50300000, N'Moved to warehouse', 9)
INSERT [dbo].[InventoryArchive] ([inventory_id], [quantity], [location_id], [inventory_type_id], [date_updated], [updated_by], [comment], [inventory_archive_id]) VALUES (2, 50, 7, 7, CAST(N'2017-01-05T17:00:00.0000000' AS DateTime2), 50300000, N'Moved to warehouse', 10)
INSERT [dbo].[InventoryArchive] ([inventory_id], [quantity], [location_id], [inventory_type_id], [date_updated], [updated_by], [comment], [inventory_archive_id]) VALUES (5, 50, 7, 7, CAST(N'2017-01-05T17:00:00.0000000' AS DateTime2), 50300000, N'Moved to warehouse', 11)
SET IDENTITY_INSERT [dbo].[InventoryArchive] OFF
SET IDENTITY_INSERT [dbo].[InventoryType] ON 

INSERT [dbo].[InventoryType] ([inventory_type], [inventory_type_id]) VALUES (N'Store', 7)
INSERT [dbo].[InventoryType] ([inventory_type], [inventory_type_id]) VALUES (N'WareHouse', 4)
SET IDENTITY_INSERT [dbo].[InventoryType] OFF
SET IDENTITY_INSERT [dbo].[LoginGroup] ON 

INSERT [dbo].[LoginGroup] ([group_name], [description], [group_id]) VALUES (N'AdminClinic', N'Administrator of Clinic', 1)
INSERT [dbo].[LoginGroup] ([group_name], [description], [group_id]) VALUES (N'Doctor', N'Doctor of Clinic', 2)
INSERT [dbo].[LoginGroup] ([group_name], [description], [group_id]) VALUES (N'Nurse', N'Nurse of Clinic', 5)
SET IDENTITY_INSERT [dbo].[LoginGroup] OFF
INSERT [dbo].[MartialStatus] ([MartialStatusId], [MartialStatusName]) VALUES (1, N'Married')
INSERT [dbo].[MartialStatus] ([MartialStatusId], [MartialStatusName]) VALUES (2, N'Single')
INSERT [dbo].[MartialStatus] ([MartialStatusId], [MartialStatusName]) VALUES (3, N'Divorced')
INSERT [dbo].[MartialStatus] ([MartialStatusId], [MartialStatusName]) VALUES (4, N'Widowed')
SET IDENTITY_INSERT [dbo].[Medicine] ON 

INSERT [dbo].[Medicine] ([medicine_name], [package_type], [weight], [price], [medicine_id], [manufacturer_id]) VALUES (N'Acetaminophen', 1, 200, CAST(5.00 AS Decimal(7, 2)), 4, 4)
INSERT [dbo].[Medicine] ([medicine_name], [package_type], [weight], [price], [medicine_id], [manufacturer_id]) VALUES (N'Acetaminophen', 1, 800, CAST(10.00 AS Decimal(7, 2)), 7, 4)
INSERT [dbo].[Medicine] ([medicine_name], [package_type], [weight], [price], [medicine_id], [manufacturer_id]) VALUES (N'Acetaminophen', 1, 1200, CAST(10.00 AS Decimal(7, 2)), 9, 4)
SET IDENTITY_INSERT [dbo].[Medicine] OFF
SET IDENTITY_INSERT [dbo].[Nurse] ON 

INSERT [dbo].[Nurse] ([PersonId], [PassCode], [NurseId]) VALUES (1234569788, N'123', 50100000)
INSERT [dbo].[Nurse] ([PersonId], [PassCode], [NurseId]) VALUES (999999976, N'e10adc3949ba59abbe56e057f20f883e', 50100001)
SET IDENTITY_INSERT [dbo].[Nurse] OFF
INSERT [dbo].[Occupation] ([occupation_id], [occupation_name]) VALUES (1, N'Student')
INSERT [dbo].[Occupation] ([occupation_id], [occupation_name]) VALUES (2, N'Employee')
INSERT [dbo].[Occupation] ([occupation_id], [occupation_name]) VALUES (3, N'Unemployed')
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([patient_id], [pharmacist_id], [prescription_id], [date_ordered], [order_id]) VALUES (1, 50200000, 1, CAST(N'2017-01-05T21:00:00.0000000' AS DateTime2), 1)
SET IDENTITY_INSERT [dbo].[Order] OFF
SET IDENTITY_INSERT [dbo].[OrderItem] ON 

INSERT [dbo].[OrderItem] ([medicine_id], [order_id], [order_item_id], [item_quantity]) VALUES (7, 1, 1, 2)
INSERT [dbo].[OrderItem] ([medicine_id], [order_id], [order_item_id], [item_quantity]) VALUES (5, 1, 7, 2)
INSERT [dbo].[OrderItem] ([medicine_id], [order_id], [order_item_id], [item_quantity]) VALUES (2, 1, 9, 2)
SET IDENTITY_INSERT [dbo].[OrderItem] OFF
SET IDENTITY_INSERT [dbo].[PackageType] ON 

INSERT [dbo].[PackageType] ([name], [package_type_id]) VALUES (N'Tablets', 1)
SET IDENTITY_INSERT [dbo].[PackageType] OFF
SET IDENTITY_INSERT [dbo].[Patient] ON 

INSERT [dbo].[Patient] ([person_id], [pass_code], [patient_id], [occupation_id]) VALUES (1234569788, N'123', 1, 1)
SET IDENTITY_INSERT [dbo].[Patient] OFF
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (1111, N'sds', N'sds', N'sd', CAST(N'2017-05-05' AS Date), 2, 1, 1, 1, 1019)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (1212, N'1212', N'121', N'1212', CAST(N'2015-05-02' AS Date), 2, 2, 2, 1, 4)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (3324, N'sdsd', N'sd', N'sdd', CAST(N'2017-05-06' AS Date), 2, 1, 1, 1, 1015)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (12222, N'as', N'as', N'as', CAST(N'2017-05-05' AS Date), 2, 1, 1, 1, 1020)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (121212, N'asasa', N'asas', N'asas', CAST(N'2014-05-03' AS Date), 2, 2, 2, 1, 8)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (213213, N'2131', N'', N'123213', CAST(N'2017-05-04' AS Date), 2, 1, 1, 1, 2028)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (321123, N'James', N'j', N'212', CAST(N'2013-05-02' AS Date), 2, 2, 2, 1, 5)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (654321, N'james', N'dsd', N'4545', CAST(N'2013-05-03' AS Date), 2, 2, 2, 1, 6)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (777777, N'as', N'as', N'as', CAST(N'2017-05-05' AS Date), 2, 1, 1, 1, 1016)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999990, N'Ramiz', N'Ramiz', N'Hoxha', CAST(N'2015-05-02' AS Date), 4, 1, 2, 1, 3038)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999991, N'Albnora', N'', N'Hoti', CAST(N'2015-05-02' AS Date), 2, 2, 2, 1, 2026)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999992, N'Ema', N'ema', N'Kepuska', NULL, 2, 2, 2, 1, 3031)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', CAST(N'2017-05-05' AS Date), 2, 1, 2, 1, 2025)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999994, N'Lavdim', N'lavdim', N'Menxhiqi', CAST(N'2015-05-02' AS Date), 2, 1, 1, 1, 3035)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999995, N'Fisnik', N'', N'Prekazi', CAST(N'2015-05-02' AS Date), 2, 1, 1, 2, 2023)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999996, N'Albiona', N'bona', N'Hyseni', CAST(N'2015-05-02' AS Date), 4, 2, 2, 1, 2022)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999997, N'Erza', N'', N'Dinarama', CAST(N'2016-05-07' AS Date), 2, 2, 2, 1, 2022)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999998, N'Marigona', N'', N'Kastrati', CAST(N'2015-05-02' AS Date), 2, 2, 2, 1, 2022)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999999, N'dsfsdf', N'fsfdsf', N'dfsdf', CAST(N'2017-05-05' AS Date), 2, 1, 1, 1, 1022)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (3216321, N'Fatlonder', N'lon', N'Cakolli', CAST(N'2008-05-03' AS Date), 2, 1, 2, 3, 7)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (4556456, N'testName', N'testmName', N'testLastName', CAST(N'2013-05-04' AS Date), 2, 2, 2, 1, 1009)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (11114111, N'Albiona', N'Bona', N'Hyseni', CAST(N'1997-05-09' AS Date), 2, 2, 2, 1, 9)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (12111119, N'as', N'as', N'as', CAST(N'2017-05-05' AS Date), 2, 1, 1, 1, 1020)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (12121212, N'Test', N'', N'surnam', CAST(N'2017-05-05' AS Date), 2, 1, 2, 1, 3036)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (22222222, N'sd', N'sd', N'sd', CAST(N'2017-05-05' AS Date), 2, 1, 1, 1, 1017)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (78787575, N'dda', N'dsfdsf', N'dsfdfds', CAST(N'2013-05-04' AS Date), 2, 2, 2, 1, 1008)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (99999902, N'Ylli', N'Ylli', N'Petrovci', CAST(N'2014-05-03' AS Date), 4, 1, 2, 3, 3040)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999999975, N'Fatos', N'', N'Maxhuni', CAST(N'2009-06-06' AS Date), 4, 1, 1, 1, 3031)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (999999976, N'Besart', N'Besart', N'Pllana', CAST(N'1990-06-05' AS Date), 2, 1, 1, 1, 2025)
INSERT [dbo].[Person] ([PersonId], [FirstName], [MiddleName], [LastName], [DateOfBirth], [ReigionId], [GenderId], [MartialStatusId], [BirthCityId], [AddressId]) VALUES (1234569788, N'Fatlonder', N'lon', N'Cakolli', CAST(N'2000-02-02' AS Date), 4, 1, 2, 1, 3032)
SET IDENTITY_INSERT [dbo].[PersonArchive] ON 

INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999994, N'Lavdim', N'', N'Menxhiqi', 2, 1, 1, 2024, 11, CAST(N'2017-05-23T00:05:01.257' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999992, N'Ema', N'', N'Kepuska', 2, 2, 2, 2025, 12, CAST(N'2017-05-23T00:07:59.673' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (1234569788, N'Fatlonder', NULL, N'Cakolli', 3, 1, 2, 2, 13, CAST(N'2017-05-23T00:19:49.153' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 14, CAST(N'2017-05-23T01:59:59.270' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 15, CAST(N'2017-05-23T02:01:33.663' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 16, CAST(N'2017-05-23T02:02:48.960' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 17, CAST(N'2017-05-23T02:04:54.377' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 18, CAST(N'2017-05-23T02:07:13.117' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 19, CAST(N'2017-05-23T02:09:16.880' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 20, CAST(N'2017-05-23T02:26:43.027' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999993, N'Blerim', N'Blerim', N'Zylfiu', 2, 1, 2, 2025, 21, CAST(N'2017-05-23T02:31:15.317' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999996, N'Albiona', N'', N'Hyseni', 2, 2, 2, 2022, 22, CAST(N'2017-05-23T02:32:08.507' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999996, N'Albiona', N'bona', N'Hyseni', 2, 2, 2, 2022, 23, CAST(N'2017-05-23T02:32:19.940' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999996, N'Albiona', N'bona', N'Hyseni', 4, 2, 2, 2022, 24, CAST(N'2017-05-23T02:33:03.757' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999996, N'Albiona', N'bona', N'Hyseni', 4, 2, 2, 3033, 25, CAST(N'2017-05-23T02:33:15.650' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (99999902, N'Ylli', N'', N'Petrovci', 2, 1, 1, 3034, 26, CAST(N'2017-05-23T04:41:04.437' AS DateTime))
INSERT [dbo].[PersonArchive] ([PersonId], [FirstName], [MiddleName], [LastName], [ReligionId], [GenderId], [MartialStatusId], [AddressId], [PersonArchiveId], [DateChanged]) VALUES (999994, N'Lavdim', N'lavdim', N'Menxhiqi', 2, 1, 1, 3030, 27, CAST(N'2017-05-25T10:03:41.367' AS DateTime))
SET IDENTITY_INSERT [dbo].[PersonArchive] OFF
SET IDENTITY_INSERT [dbo].[PersonEducation] ON 

INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (1234569788, 1, CAST(N'2015-01-10' AS Date), CAST(N'2018-01-06' AS Date), 1)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (1234569788, 4, CAST(N'2015-01-10' AS Date), CAST(N'2018-01-06' AS Date), 4)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (12111119, 1, CAST(N'2017-05-20' AS Date), CAST(N'2017-05-26' AS Date), 6)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999999, 1, CAST(N'2017-05-06' AS Date), CAST(N'2017-05-10' AS Date), 7)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999998, 1, CAST(N'2017-05-06' AS Date), CAST(N'2017-05-05' AS Date), 1007)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999997, 1, CAST(N'2015-05-01' AS Date), CAST(N'2015-05-01' AS Date), 1008)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999996, 1, CAST(N'2014-05-01' AS Date), CAST(N'2015-05-02' AS Date), 1009)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999994, 1, CAST(N'2015-05-02' AS Date), CAST(N'2015-05-16' AS Date), 1010)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999993, 8, CAST(N'2015-05-01' AS Date), CAST(N'2015-05-30' AS Date), 1011)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999993, 9, CAST(N'2015-05-02' AS Date), CAST(N'2015-05-30' AS Date), 1012)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999991, 7, CAST(N'2017-05-06' AS Date), CAST(N'2017-05-27' AS Date), 1013)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999990, 7, CAST(N'2017-05-06' AS Date), CAST(N'2017-05-27' AS Date), 1014)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (999993, 10, CAST(N'2017-05-02' AS Date), CAST(N'2017-05-26' AS Date), 1015)
INSERT [dbo].[PersonEducation] ([PersonId], [EducationId], [DateStart], [DateEnd], [PersonEducationId]) VALUES (99999902, 7, CAST(N'2017-05-04' AS Date), CAST(N'2017-05-20' AS Date), 1016)
SET IDENTITY_INSERT [dbo].[PersonEducation] OFF
SET IDENTITY_INSERT [dbo].[Pharmacist] ON 

INSERT [dbo].[Pharmacist] ([PersonId], [PassCode], [PharmacistId]) VALUES (1234569788, N'123', 50200000)
SET IDENTITY_INSERT [dbo].[Pharmacist] OFF
SET IDENTITY_INSERT [dbo].[Pharmacy_Manager] ON 

INSERT [dbo].[Pharmacy_Manager] ([person_id], [pass_code], [pharmacy_manager_id]) VALUES (1234569788, N'123', 50300000)
SET IDENTITY_INSERT [dbo].[Pharmacy_Manager] OFF
SET IDENTITY_INSERT [dbo].[Prescription] ON 

INSERT [dbo].[Prescription] ([comment/desc], [prescription_id]) VALUES (N'Soft Flue', 1)
INSERT [dbo].[Prescription] ([comment/desc], [prescription_id]) VALUES (N'Throat Infection', 2)
SET IDENTITY_INSERT [dbo].[Prescription] OFF
SET IDENTITY_INSERT [dbo].[PrescriptionMedicines] ON 

INSERT [dbo].[PrescriptionMedicines] ([PrescriptionId], [MedicineId], [DaysToUse], [times_per_day], [comment], [prescribed_medicine_id]) VALUES (1, 7, 3, 2, N'Use after meal', 1)
INSERT [dbo].[PrescriptionMedicines] ([PrescriptionId], [MedicineId], [DaysToUse], [times_per_day], [comment], [prescribed_medicine_id]) VALUES (1, 4, 3, 1, N'Use after meal', 4)
INSERT [dbo].[PrescriptionMedicines] ([PrescriptionId], [MedicineId], [DaysToUse], [times_per_day], [comment], [prescribed_medicine_id]) VALUES (1, 9, 3, 1, N'Use after meal', 5)
SET IDENTITY_INSERT [dbo].[PrescriptionMedicines] OFF
SET IDENTITY_INSERT [dbo].[Receptionist] ON 

INSERT [dbo].[Receptionist] ([PersonId], [pass_code], [receptionist_id]) VALUES (1234569788, N'123', 50400000)
SET IDENTITY_INSERT [dbo].[Receptionist] OFF
SET IDENTITY_INSERT [dbo].[Religion] ON 

INSERT [dbo].[Religion] ([name], [religion_id]) VALUES (N'Muslim', 2)
INSERT [dbo].[Religion] ([name], [religion_id]) VALUES (N'Christian', 3)
INSERT [dbo].[Religion] ([name], [religion_id]) VALUES (N'Other', 4)
SET IDENTITY_INSERT [dbo].[Religion] OFF
SET IDENTITY_INSERT [dbo].[Schedule] ON 

INSERT [dbo].[Schedule] ([DoctorId], [status], [DateStart], [DateEnd], [TimeStart], [TimeEnd], [ManagerId], [ScheduleId]) VALUES (50000001, 2, CAST(N'2017-05-05' AS Date), CAST(N'2017-05-05' AS Date), CAST(N'17:10:00' AS Time), CAST(N'19:10:00' AS Time), 50700000, 1005)
INSERT [dbo].[Schedule] ([DoctorId], [status], [DateStart], [DateEnd], [TimeStart], [TimeEnd], [ManagerId], [ScheduleId]) VALUES (50000001, 4, CAST(N'2017-05-05' AS Date), CAST(N'2017-05-05' AS Date), CAST(N'08:00:00' AS Time), CAST(N'10:00:00' AS Time), 50700000, 1)
INSERT [dbo].[Schedule] ([DoctorId], [status], [DateStart], [DateEnd], [TimeStart], [TimeEnd], [ManagerId], [ScheduleId]) VALUES (50000001, 4, CAST(N'2017-05-05' AS Date), CAST(N'2017-05-05' AS Date), CAST(N'10:10:00' AS Time), CAST(N'11:10:00' AS Time), 50700000, 2)
INSERT [dbo].[Schedule] ([DoctorId], [status], [DateStart], [DateEnd], [TimeStart], [TimeEnd], [ManagerId], [ScheduleId]) VALUES (50000001, 4, CAST(N'2017-05-05' AS Date), CAST(N'2017-05-05' AS Date), CAST(N'12:10:00' AS Time), CAST(N'13:10:00' AS Time), 50700000, 1002)
INSERT [dbo].[Schedule] ([DoctorId], [status], [DateStart], [DateEnd], [TimeStart], [TimeEnd], [ManagerId], [ScheduleId]) VALUES (50000001, 4, CAST(N'2017-05-05' AS Date), CAST(N'2017-05-05' AS Date), CAST(N'17:10:00' AS Time), CAST(N'19:10:00' AS Time), 50700000, 1003)
SET IDENTITY_INSERT [dbo].[Schedule] OFF
SET IDENTITY_INSERT [dbo].[ScheduleStatus] ON 

INSERT [dbo].[ScheduleStatus] ([ScheduleStatusId], [StatusName]) VALUES (4, N'Canceled')
INSERT [dbo].[ScheduleStatus] ([ScheduleStatusId], [StatusName]) VALUES (2, N'Planned')
SET IDENTITY_INSERT [dbo].[ScheduleStatus] OFF
SET IDENTITY_INSERT [dbo].[UserGroup] ON 

INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50000000, 2, 13)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50001014, 2, 15)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002014, 2, 1015)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002015, 2, 1016)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002016, 2, 1017)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002018, 2, 1018)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002019, 2, 1019)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002021, 2, 1020)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002022, 2, 1021)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50002023, 2, 1022)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50003023, 2, 2022)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50003024, 2, 2023)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50003027, 2, 2024)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50100001, 5, 2025)
INSERT [dbo].[UserGroup] ([user_id], [group_id], [usr_group_id]) VALUES (50500000, 1, 11)
SET IDENTITY_INSERT [dbo].[UserGroup] OFF
SET IDENTITY_INSERT [dbo].[Visit] ON 

INSERT [dbo].[Visit] ([BookId], [PrescriptionID], [DateTimeStart], [DateTimeEnd], [status], [VisitId]) VALUES (7, 1, CAST(N'2017-12-05T12:20:00.0000000' AS DateTime2), CAST(N'2017-12-05T13:00:00.0000000' AS DateTime2), N'Visited', 4)
INSERT [dbo].[Visit] ([BookId], [PrescriptionID], [DateTimeStart], [DateTimeEnd], [status], [VisitId]) VALUES (7, 1, CAST(N'2017-12-05T12:20:00.0000000' AS DateTime2), CAST(N'2017-12-05T13:00:00.0000000' AS DateTime2), N'Canceled', 7)
SET IDENTITY_INSERT [dbo].[Visit] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_City_PostCode_StrName_AppNo_Address]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Address] ADD  CONSTRAINT [UQ_City_PostCode_StrName_AppNo_Address] UNIQUE NONCLUSTERED 
(
	[city_id] ASC,
	[building_number] ASC,
	[street_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Clin_Admin]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[AdminClinic] ADD  CONSTRAINT [UQ_Per_Clin_Admin] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_RoleName_RoleCode]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[ApplicationRole] ADD  CONSTRAINT [UQ_RoleName_RoleCode] UNIQUE NONCLUSTERED 
(
	[role_code] ASC,
	[role_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Amount_PaymentType_Bill]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Bill] ADD  CONSTRAINT [UQ_Amount_PaymentType_Bill] UNIQUE NONCLUSTERED 
(
	[Amount] ASC,
	[payment_type] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Visit_BillPayment]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[BillPayment] ADD  CONSTRAINT [UQ_Visit_BillPayment] UNIQUE NONCLUSTERED 
(
	[VisitId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Schedule_Patient_Status_BookAppointment]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[BookAppointment] ADD  CONSTRAINT [UQ_Schedule_Patient_Status_BookAppointment] UNIQUE NONCLUSTERED 
(
	[ScheduleId] ASC,
	[PatientId] ASC,
	[status] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Per_Contact]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Contact] ADD  CONSTRAINT [UQ_Per_Contact] UNIQUE NONCLUSTERED 
(
	[PersonId] ASC,
	[Value] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_Country]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Country] ADD  CONSTRAINT [UQ_Name_Country] UNIQUE NONCLUSTERED 
(
	[country_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Doc]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Doctor] ADD  CONSTRAINT [UQ_Per_Doc] UNIQUE NONCLUSTERED 
(
	[PersonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_DrugManufacturer]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[DrugManufacturer] ADD  CONSTRAINT [UQ_Name_DrugManufacturer] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_EducationType_EducationProgram_Education]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Education] ADD  CONSTRAINT [UQ_EducationType_EducationProgram_Education] UNIQUE NONCLUSTERED 
(
	[EucationTypeId] ASC,
	[EducationProgramId] ASC,
	[InstitutionName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_EducationProgram]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[EducationProgram] ADD  CONSTRAINT [UQ_Name_EducationProgram] UNIQUE NONCLUSTERED 
(
	[ProgramName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Person_Patient_EmergencyContact]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Emergency_Information] ADD  CONSTRAINT [UQ_Person_Patient_EmergencyContact] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_Food]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Food] ADD  CONSTRAINT [UQ_Name_Food] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Role_Group_GroupRole]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[GroupRole] ADD  CONSTRAINT [UQ_Role_Group_GroupRole] UNIQUE NONCLUSTERED 
(
	[group_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Person_Child_Guardian]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Guardian] ADD  CONSTRAINT [UQ_Person_Child_Guardian] UNIQUE NONCLUSTERED 
(
	[ParentID] ASC,
	[ChildId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_HRMan]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[HRManager] ADD  CONSTRAINT [UQ_Per_HRMan] UNIQUE NONCLUSTERED 
(
	[PersonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_InfectiousDisease]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[InfectiousDisease] ADD  CONSTRAINT [UQ_Name_InfectiousDisease] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Location_InventoryType_Medicine_Inventory]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Inventory] ADD  CONSTRAINT [UQ_Location_InventoryType_Medicine_Inventory] UNIQUE NONCLUSTERED 
(
	[medicine_id] ASC,
	[location_id] ASC,
	[inventory_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Inventory_DateTime_InventoryArchive]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[InventoryArchive] ADD  CONSTRAINT [UQ_Inventory_DateTime_InventoryArchive] UNIQUE NONCLUSTERED 
(
	[inventory_id] ASC,
	[date_updated] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [Uq_InventoryType]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[InventoryType] ADD  CONSTRAINT [Uq_InventoryType] UNIQUE NONCLUSTERED 
(
	[inventory_type] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_Description_LoginGroup]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[LoginGroup] ADD  CONSTRAINT [UQ_Name_Description_LoginGroup] UNIQUE NONCLUSTERED 
(
	[group_name] ASC,
	[description] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_MedName_PackageType_Weight_Manufacturer_Medicine]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Medicine] ADD  CONSTRAINT [UQ_MedName_PackageType_Weight_Manufacturer_Medicine] UNIQUE NONCLUSTERED 
(
	[medicine_name] ASC,
	[package_type] ASC,
	[weight] ASC,
	[manufacturer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_MentalHealth]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[MentalHealth] ADD  CONSTRAINT [UQ_Name_MentalHealth] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Nur]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Nurse] ADD  CONSTRAINT [UQ_Per_Nur] UNIQUE NONCLUSTERED 
(
	[PersonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Pharmacist_Prescription_Order]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Order] ADD  CONSTRAINT [UQ_Patient_Pharmacist_Prescription_Order] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[pharmacist_id] ASC,
	[prescription_id] ASC,
	[date_ordered] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Medicine_Order_OrderItem]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[OrderItem] ADD  CONSTRAINT [UQ_Medicine_Order_OrderItem] UNIQUE NONCLUSTERED 
(
	[medicine_id] ASC,
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_PackageType]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PackageType] ADD  CONSTRAINT [UQ_Name_PackageType] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Pat]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Patient] ADD  CONSTRAINT [UQ_Per_Pat] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Food_PatientFoodAllergylHX]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientFoodAllergylHX] ADD  CONSTRAINT [UQ_Patient_Food_PatientFoodAllergylHX] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[food_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_InfectiousDisease_dateTaken_PatientInfectiousDiseaseHX]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientInfectiousDiseaseHX] ADD  CONSTRAINT [UQ_Patient_InfectiousDisease_dateTaken_PatientInfectiousDiseaseHX] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[infectious_disease_id] ASC,
	[date_taken] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Medicine_Patient_Alergis]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientMedicineAllergy] ADD  CONSTRAINT [UQ_Medicine_Patient_Alergis] UNIQUE NONCLUSTERED 
(
	[medicine_id] ASC,
	[patient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_MentalHealth_dateTaken_PatientMentalHealthHX]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientMentalHealthHX] ADD  CONSTRAINT [UQ_Patient_MentalHealth_dateTaken_PatientMentalHealthHX] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[mental_health_id] ASC,
	[date_taken] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Relative_PatientRelative]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientRelative] ADD  CONSTRAINT [UQ_Patient_Relative_PatientRelative] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[relative_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Skin_dateTaken_PatientSkinHX]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientSkinHX] ADD  CONSTRAINT [UQ_Patient_Skin_dateTaken_PatientSkinHX] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[skin_id] ASC,
	[date_taken] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Surgical_dateTaken_PatientSurgicalHX]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientSurgicalHX] ADD  CONSTRAINT [UQ_Patient_Surgical_dateTaken_PatientSurgicalHX] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[surgical_id] ASC,
	[date_taken] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Vaccine_dateTaken_PatientVaccineHX]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientVaccineHX] ADD  CONSTRAINT [UQ_Patient_Vaccine_dateTaken_PatientVaccineHX] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[vaccine_id] ASC,
	[date_taken] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Vital_dateTaken_PatientVitalHX]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PatientVitalHX] ADD  CONSTRAINT [UQ_Patient_Vital_dateTaken_PatientVitalHX] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[vital_id] ASC,
	[date_taken] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Gender_Religio_Person_MartStat_Address_DateCh_PersonArchive]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PersonArchive] ADD  CONSTRAINT [UQ_Gender_Religio_Person_MartStat_Address_DateCh_PersonArchive] UNIQUE NONCLUSTERED 
(
	[PersonId] ASC,
	[ReligionId] ASC,
	[GenderId] ASC,
	[DateChanged] ASC,
	[AddressId] ASC,
	[MartialStatusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Education_Person_PersonEducation]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PersonEducation] ADD  CONSTRAINT [UQ_Education_Person_PersonEducation] UNIQUE NONCLUSTERED 
(
	[EducationId] ASC,
	[PersonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Phar]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Pharmacist] ADD  CONSTRAINT [UQ_Per_Phar] UNIQUE NONCLUSTERED 
(
	[PersonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Phar_Man]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Pharmacy_Manager] ADD  CONSTRAINT [UQ_Per_Phar_Man] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Comment_Prescription]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Prescription] ADD  CONSTRAINT [UQ_Comment_Prescription] UNIQUE NONCLUSTERED 
(
	[comment/desc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Medicine_Prescription_PrescriptionMedicines]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[PrescriptionMedicines] ADD  CONSTRAINT [UQ_Medicine_Prescription_PrescriptionMedicines] UNIQUE NONCLUSTERED 
(
	[MedicineId] ASC,
	[PrescriptionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Rec]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Receptionist] ADD  CONSTRAINT [UQ_Per_Rec] UNIQUE NONCLUSTERED 
(
	[PersonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_FamilyRelativeType]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[RelativeType] ADD  CONSTRAINT [UQ_Name_FamilyRelativeType] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Doc_Man_Schedule_date_time]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Schedule] ADD  CONSTRAINT [UQ_Doc_Man_Schedule_date_time] UNIQUE NONCLUSTERED 
(
	[status] ASC,
	[ManagerId] ASC,
	[DoctorId] ASC,
	[DateStart] ASC,
	[DateEnd] ASC,
	[TimeStart] ASC,
	[TimeEnd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_StatusName_ScheduleStatus]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[ScheduleStatus] ADD  CONSTRAINT [UQ_StatusName_ScheduleStatus] UNIQUE NONCLUSTERED 
(
	[StatusName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_Skin]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Skin] ADD  CONSTRAINT [UQ_Name_Skin] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_Surgical]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Surgical] ADD  CONSTRAINT [UQ_Name_Surgical] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_User_Group_UserGroup]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[UserGroup] ADD  CONSTRAINT [UQ_User_Group_UserGroup] UNIQUE NONCLUSTERED 
(
	[user_id] ASC,
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Name_Vaccine]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Vaccine] ADD  CONSTRAINT [UQ_Name_Vaccine] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Book_Status_Visit]    Script Date: 6/9/2017 2:31:39 AM ******/
ALTER TABLE [dbo].[Visit] ADD  CONSTRAINT [UQ_Book_Status_Visit] UNIQUE NONCLUSTERED 
(
	[BookId] ASC,
	[status] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[PersonArchive] ADD  DEFAULT (getdate()) FOR [DateChanged]
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [FK_City_Address] FOREIGN KEY([city_id])
REFERENCES [dbo].[City] ([city_id])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [FK_City_Address]
GO
ALTER TABLE [dbo].[AdminClinic]  WITH CHECK ADD  CONSTRAINT [FK_Per_Clin_Admin] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[AdminClinic] CHECK CONSTRAINT [FK_Per_Clin_Admin]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Bill_BillPayment] FOREIGN KEY([BillId])
REFERENCES [dbo].[Bill] ([BillId])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Bill_BillPayment]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Patient_BillPayment] FOREIGN KEY([PatientId])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Patient_BillPayment]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Receptionist_BillPayment] FOREIGN KEY([ReceptionistID])
REFERENCES [dbo].[Receptionist] ([receptionist_id])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Receptionist_BillPayment]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Visit_BillPayment] FOREIGN KEY([VisitId])
REFERENCES [dbo].[Visit] ([VisitId])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Visit_BillPayment]
GO
ALTER TABLE [dbo].[BookAppointment]  WITH CHECK ADD  CONSTRAINT [FK_Patient_BookAppointment] FOREIGN KEY([PatientId])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[BookAppointment] CHECK CONSTRAINT [FK_Patient_BookAppointment]
GO
ALTER TABLE [dbo].[BookAppointment]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_BookAppointment] FOREIGN KEY([ScheduleId])
REFERENCES [dbo].[Schedule] ([ScheduleId])
GO
ALTER TABLE [dbo].[BookAppointment] CHECK CONSTRAINT [FK_Schedule_BookAppointment]
GO
ALTER TABLE [dbo].[City]  WITH CHECK ADD  CONSTRAINT [FK_Country_City] FOREIGN KEY([country_id])
REFERENCES [dbo].[Country] ([country_id])
GO
ALTER TABLE [dbo].[City] CHECK CONSTRAINT [FK_Country_City]
GO
ALTER TABLE [dbo].[Contact]  WITH CHECK ADD  CONSTRAINT [FK_Per_Contact] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Contact] CHECK CONSTRAINT [FK_Per_Contact]
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD  CONSTRAINT [FK_Per_Doc] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Doctor] CHECK CONSTRAINT [FK_Per_Doc]
GO
ALTER TABLE [dbo].[DrugManufacturer]  WITH CHECK ADD  CONSTRAINT [FK_Address_DrugManufacturer] FOREIGN KEY([address_id])
REFERENCES [dbo].[Address] ([address_id])
GO
ALTER TABLE [dbo].[DrugManufacturer] CHECK CONSTRAINT [FK_Address_DrugManufacturer]
GO
ALTER TABLE [dbo].[Education]  WITH CHECK ADD  CONSTRAINT [FK_EducationProgram_Education] FOREIGN KEY([EducationProgramId])
REFERENCES [dbo].[EducationProgram] ([EducationProgramId])
GO
ALTER TABLE [dbo].[Education] CHECK CONSTRAINT [FK_EducationProgram_Education]
GO
ALTER TABLE [dbo].[Education]  WITH CHECK ADD  CONSTRAINT [FK_EducationType_Education] FOREIGN KEY([EucationTypeId])
REFERENCES [dbo].[EducationType] ([EducationTypeId])
GO
ALTER TABLE [dbo].[Education] CHECK CONSTRAINT [FK_EducationType_Education]
GO
ALTER TABLE [dbo].[Emergency_Information]  WITH CHECK ADD  CONSTRAINT [FK_Patient_EmergencyContact] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[Emergency_Information] CHECK CONSTRAINT [FK_Patient_EmergencyContact]
GO
ALTER TABLE [dbo].[Emergency_Information]  WITH CHECK ADD  CONSTRAINT [FK_Person_EmergencyContact] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Emergency_Information] CHECK CONSTRAINT [FK_Person_EmergencyContact]
GO
ALTER TABLE [dbo].[GroupRole]  WITH CHECK ADD  CONSTRAINT [FK_Group_GroupRole] FOREIGN KEY([group_id])
REFERENCES [dbo].[LoginGroup] ([group_id])
GO
ALTER TABLE [dbo].[GroupRole] CHECK CONSTRAINT [FK_Group_GroupRole]
GO
ALTER TABLE [dbo].[GroupRole]  WITH CHECK ADD  CONSTRAINT [FK_Role_GroupRole] FOREIGN KEY([role_id])
REFERENCES [dbo].[ApplicationRole] ([role_id])
GO
ALTER TABLE [dbo].[GroupRole] CHECK CONSTRAINT [FK_Role_GroupRole]
GO
ALTER TABLE [dbo].[Guardian]  WITH CHECK ADD  CONSTRAINT [FK_child_Guardian] FOREIGN KEY([ChildId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Guardian] CHECK CONSTRAINT [FK_child_Guardian]
GO
ALTER TABLE [dbo].[Guardian]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Guardian] FOREIGN KEY([ParentID])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Guardian] CHECK CONSTRAINT [FK_Patient_Guardian]
GO
ALTER TABLE [dbo].[HRManager]  WITH CHECK ADD  CONSTRAINT [FK_Per_HRMan] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[HRManager] CHECK CONSTRAINT [FK_Per_HRMan]
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD  CONSTRAINT [FK_InventoryType_Inventory] FOREIGN KEY([inventory_type_id])
REFERENCES [dbo].[InventoryType] ([inventory_type_id])
GO
ALTER TABLE [dbo].[Inventory] CHECK CONSTRAINT [FK_InventoryType_Inventory]
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD  CONSTRAINT [FK_Location_Inventory] FOREIGN KEY([location_id])
REFERENCES [dbo].[Address] ([address_id])
GO
ALTER TABLE [dbo].[Inventory] CHECK CONSTRAINT [FK_Location_Inventory]
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_Inventory] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[Medicine] ([medicine_id])
GO
ALTER TABLE [dbo].[Inventory] CHECK CONSTRAINT [FK_Medicine_Inventory]
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD  CONSTRAINT [FK_PharManager_Inventory] FOREIGN KEY([updated_by])
REFERENCES [dbo].[Pharmacy_Manager] ([pharmacy_manager_id])
GO
ALTER TABLE [dbo].[Inventory] CHECK CONSTRAINT [FK_PharManager_Inventory]
GO
ALTER TABLE [dbo].[InventoryArchive]  WITH CHECK ADD  CONSTRAINT [FK_Inventory_InventoryArchive] FOREIGN KEY([inventory_id])
REFERENCES [dbo].[Inventory] ([inventory_id])
GO
ALTER TABLE [dbo].[InventoryArchive] CHECK CONSTRAINT [FK_Inventory_InventoryArchive]
GO
ALTER TABLE [dbo].[InventoryArchive]  WITH CHECK ADD  CONSTRAINT [FK_InventoryType_InventoryArchive] FOREIGN KEY([inventory_type_id])
REFERENCES [dbo].[InventoryType] ([inventory_type_id])
GO
ALTER TABLE [dbo].[InventoryArchive] CHECK CONSTRAINT [FK_InventoryType_InventoryArchive]
GO
ALTER TABLE [dbo].[InventoryArchive]  WITH CHECK ADD  CONSTRAINT [FK_Location_InventoryArchive] FOREIGN KEY([location_id])
REFERENCES [dbo].[Address] ([address_id])
GO
ALTER TABLE [dbo].[InventoryArchive] CHECK CONSTRAINT [FK_Location_InventoryArchive]
GO
ALTER TABLE [dbo].[InventoryArchive]  WITH CHECK ADD  CONSTRAINT [FK_PharManager_InventoryArchive] FOREIGN KEY([updated_by])
REFERENCES [dbo].[Pharmacy_Manager] ([pharmacy_manager_id])
GO
ALTER TABLE [dbo].[InventoryArchive] CHECK CONSTRAINT [FK_PharManager_InventoryArchive]
GO
ALTER TABLE [dbo].[Medicine]  WITH CHECK ADD  CONSTRAINT [FK_DrugManufacturer_Medicine] FOREIGN KEY([manufacturer_id])
REFERENCES [dbo].[DrugManufacturer] ([drug_manufacturer_id])
GO
ALTER TABLE [dbo].[Medicine] CHECK CONSTRAINT [FK_DrugManufacturer_Medicine]
GO
ALTER TABLE [dbo].[Medicine]  WITH CHECK ADD  CONSTRAINT [FK_PackageType_Medicine] FOREIGN KEY([package_type])
REFERENCES [dbo].[PackageType] ([package_type_id])
GO
ALTER TABLE [dbo].[Medicine] CHECK CONSTRAINT [FK_PackageType_Medicine]
GO
ALTER TABLE [dbo].[Nurse]  WITH CHECK ADD  CONSTRAINT [FK_Per_Nur] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Nurse] CHECK CONSTRAINT [FK_Per_Nur]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Orders] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Patient_Orders]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Pharmacist_Orders] FOREIGN KEY([pharmacist_id])
REFERENCES [dbo].[Pharmacist] ([PharmacistId])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Pharmacist_Orders]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Prescription_Orders] FOREIGN KEY([prescription_id])
REFERENCES [dbo].[Prescription] ([prescription_id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Prescription_Orders]
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD  CONSTRAINT [FK_Inventory_OrderItem] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[Inventory] ([inventory_id])
GO
ALTER TABLE [dbo].[OrderItem] CHECK CONSTRAINT [FK_Inventory_OrderItem]
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD  CONSTRAINT [FK_Order_OrderItem] FOREIGN KEY([order_id])
REFERENCES [dbo].[Order] ([order_id])
GO
ALTER TABLE [dbo].[OrderItem] CHECK CONSTRAINT [FK_Order_OrderItem]
GO
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Occupation_Pat] FOREIGN KEY([occupation_id])
REFERENCES [dbo].[Occupation] ([occupation_id])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Occupation_Pat]
GO
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Per_Pat] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Per_Pat]
GO
ALTER TABLE [dbo].[PatientFoodAllergylHX]  WITH CHECK ADD  CONSTRAINT [FK_Food_PatientFoodAllergylHX] FOREIGN KEY([food_id])
REFERENCES [dbo].[Food] ([food_id])
GO
ALTER TABLE [dbo].[PatientFoodAllergylHX] CHECK CONSTRAINT [FK_Food_PatientFoodAllergylHX]
GO
ALTER TABLE [dbo].[PatientFoodAllergylHX]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientFoodAllergylHX] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientFoodAllergylHX] CHECK CONSTRAINT [FK_Patient_PatientFoodAllergylHX]
GO
ALTER TABLE [dbo].[PatientInfectiousDiseaseHX]  WITH CHECK ADD  CONSTRAINT [FK_InfectiousDisease_PatientVaccineHX] FOREIGN KEY([infectious_disease_id])
REFERENCES [dbo].[InfectiousDisease] ([infectious_disease_id])
GO
ALTER TABLE [dbo].[PatientInfectiousDiseaseHX] CHECK CONSTRAINT [FK_InfectiousDisease_PatientVaccineHX]
GO
ALTER TABLE [dbo].[PatientInfectiousDiseaseHX]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientInfectiousDiseaseHX] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientInfectiousDiseaseHX] CHECK CONSTRAINT [FK_Patient_PatientInfectiousDiseaseHX]
GO
ALTER TABLE [dbo].[PatientMedicineAllergy]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_PatientMedicineAllergy] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[Medicine] ([medicine_id])
GO
ALTER TABLE [dbo].[PatientMedicineAllergy] CHECK CONSTRAINT [FK_Medicine_PatientMedicineAllergy]
GO
ALTER TABLE [dbo].[PatientMedicineAllergy]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientMedicineAllergy] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientMedicineAllergy] CHECK CONSTRAINT [FK_Patient_PatientMedicineAllergy]
GO
ALTER TABLE [dbo].[PatientMentalHealthHX]  WITH CHECK ADD  CONSTRAINT [FK_MentalHealth_PatientMentalHealthHX] FOREIGN KEY([mental_health_id])
REFERENCES [dbo].[MentalHealth] ([mental_health_id])
GO
ALTER TABLE [dbo].[PatientMentalHealthHX] CHECK CONSTRAINT [FK_MentalHealth_PatientMentalHealthHX]
GO
ALTER TABLE [dbo].[PatientMentalHealthHX]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientMentalHealthHX] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientMentalHealthHX] CHECK CONSTRAINT [FK_Patient_PatientMentalHealthHX]
GO
ALTER TABLE [dbo].[PatientRelative]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientRelative] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientRelative] CHECK CONSTRAINT [FK_Patient_PatientRelative]
GO
ALTER TABLE [dbo].[PatientRelative]  WITH CHECK ADD  CONSTRAINT [FK_Relative_PatientRelative] FOREIGN KEY([relative_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientRelative] CHECK CONSTRAINT [FK_Relative_PatientRelative]
GO
ALTER TABLE [dbo].[PatientRelative]  WITH CHECK ADD  CONSTRAINT [FK_RelativeType_PatientRelative] FOREIGN KEY([relative_type_id])
REFERENCES [dbo].[RelativeType] ([relative_type_id])
GO
ALTER TABLE [dbo].[PatientRelative] CHECK CONSTRAINT [FK_RelativeType_PatientRelative]
GO
ALTER TABLE [dbo].[PatientSkinHX]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientSkinHX] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientSkinHX] CHECK CONSTRAINT [FK_Patient_PatientSkinHX]
GO
ALTER TABLE [dbo].[PatientSkinHX]  WITH CHECK ADD  CONSTRAINT [FK_Skin_PatientSkinHX] FOREIGN KEY([skin_id])
REFERENCES [dbo].[Skin] ([skin_id])
GO
ALTER TABLE [dbo].[PatientSkinHX] CHECK CONSTRAINT [FK_Skin_PatientSkinHX]
GO
ALTER TABLE [dbo].[PatientSurgicalHX]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientSurgicalHX] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientSurgicalHX] CHECK CONSTRAINT [FK_Patient_PatientSurgicalHX]
GO
ALTER TABLE [dbo].[PatientSurgicalHX]  WITH CHECK ADD  CONSTRAINT [FK_Surgical_PatientSurgicalHX] FOREIGN KEY([surgical_id])
REFERENCES [dbo].[Surgical] ([surgical_id])
GO
ALTER TABLE [dbo].[PatientSurgicalHX] CHECK CONSTRAINT [FK_Surgical_PatientSurgicalHX]
GO
ALTER TABLE [dbo].[PatientVaccineHX]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientVaccineHX] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientVaccineHX] CHECK CONSTRAINT [FK_Patient_PatientVaccineHX]
GO
ALTER TABLE [dbo].[PatientVaccineHX]  WITH CHECK ADD  CONSTRAINT [FK_Vaccine_PatientVaccineHX] FOREIGN KEY([vaccine_id])
REFERENCES [dbo].[Vaccine] ([vaccine_id])
GO
ALTER TABLE [dbo].[PatientVaccineHX] CHECK CONSTRAINT [FK_Vaccine_PatientVaccineHX]
GO
ALTER TABLE [dbo].[PatientVitalHX]  WITH CHECK ADD  CONSTRAINT [FK_Patient_PatientVitalHX] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[PatientVitalHX] CHECK CONSTRAINT [FK_Patient_PatientVitalHX]
GO
ALTER TABLE [dbo].[PatientVitalHX]  WITH CHECK ADD  CONSTRAINT [FK_Vital_PatientVitalHX] FOREIGN KEY([vital_id])
REFERENCES [dbo].[Vitals] ([vital_id])
GO
ALTER TABLE [dbo].[PatientVitalHX] CHECK CONSTRAINT [FK_Vital_PatientVitalHX]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Address_Per] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Address] ([address_id])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Address_Per]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_BirthCity_Per] FOREIGN KEY([BirthCityId])
REFERENCES [dbo].[City] ([city_id])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_BirthCity_Per]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Gender_Per] FOREIGN KEY([GenderId])
REFERENCES [dbo].[Gender] ([gender_id])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Gender_Per]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_MartialStatus_Per] FOREIGN KEY([MartialStatusId])
REFERENCES [dbo].[MartialStatus] ([MartialStatusId])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_MartialStatus_Per]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Religion_Per] FOREIGN KEY([ReigionId])
REFERENCES [dbo].[Religion] ([religion_id])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Religion_Per]
GO
ALTER TABLE [dbo].[PersonArchive]  WITH CHECK ADD  CONSTRAINT [FK_Person_PersonArchive] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[PersonArchive] CHECK CONSTRAINT [FK_Person_PersonArchive]
GO
ALTER TABLE [dbo].[PersonEducation]  WITH CHECK ADD  CONSTRAINT [FK_Education_PersonEducation] FOREIGN KEY([EducationId])
REFERENCES [dbo].[Education] ([EducationId])
GO
ALTER TABLE [dbo].[PersonEducation] CHECK CONSTRAINT [FK_Education_PersonEducation]
GO
ALTER TABLE [dbo].[PersonEducation]  WITH CHECK ADD  CONSTRAINT [FK_Person_PersonEducation] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[PersonEducation] CHECK CONSTRAINT [FK_Person_PersonEducation]
GO
ALTER TABLE [dbo].[Pharmacist]  WITH CHECK ADD  CONSTRAINT [FK_Per_Phar] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Pharmacist] CHECK CONSTRAINT [FK_Per_Phar]
GO
ALTER TABLE [dbo].[Pharmacy_Manager]  WITH CHECK ADD  CONSTRAINT [FK_Per_Phar_Man] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Pharmacy_Manager] CHECK CONSTRAINT [FK_Per_Phar_Man]
GO
ALTER TABLE [dbo].[PrescriptionMedicines]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_PrescriptionMedicines] FOREIGN KEY([MedicineId])
REFERENCES [dbo].[Medicine] ([medicine_id])
GO
ALTER TABLE [dbo].[PrescriptionMedicines] CHECK CONSTRAINT [FK_Medicine_PrescriptionMedicines]
GO
ALTER TABLE [dbo].[PrescriptionMedicines]  WITH CHECK ADD  CONSTRAINT [FK_Prescription_PrescriptionMedicines] FOREIGN KEY([PrescriptionId])
REFERENCES [dbo].[Prescription] ([prescription_id])
GO
ALTER TABLE [dbo].[PrescriptionMedicines] CHECK CONSTRAINT [FK_Prescription_PrescriptionMedicines]
GO
ALTER TABLE [dbo].[Receptionist]  WITH CHECK ADD  CONSTRAINT [FK_Per_Rec] FOREIGN KEY([PersonId])
REFERENCES [dbo].[Person] ([PersonId])
GO
ALTER TABLE [dbo].[Receptionist] CHECK CONSTRAINT [FK_Per_Rec]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Doc_Schedule] FOREIGN KEY([DoctorId])
REFERENCES [dbo].[Doctor] ([DoctorId])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Doc_Schedule]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Man_Schedule] FOREIGN KEY([ManagerId])
REFERENCES [dbo].[HRManager] ([ManagerId])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Man_Schedule]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_ScheduleStatus_Schedule] FOREIGN KEY([status])
REFERENCES [dbo].[ScheduleStatus] ([ScheduleStatusId])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_ScheduleStatus_Schedule]
GO
ALTER TABLE [dbo].[UserGroup]  WITH CHECK ADD  CONSTRAINT [FK_Group_UserGroup] FOREIGN KEY([group_id])
REFERENCES [dbo].[LoginGroup] ([group_id])
GO
ALTER TABLE [dbo].[UserGroup] CHECK CONSTRAINT [FK_Group_UserGroup]
GO
ALTER TABLE [dbo].[Visit]  WITH CHECK ADD  CONSTRAINT [FK_BookAppointment_Visit] FOREIGN KEY([BookId])
REFERENCES [dbo].[BookAppointment] ([book_id])
GO
ALTER TABLE [dbo].[Visit] CHECK CONSTRAINT [FK_BookAppointment_Visit]
GO
ALTER TABLE [dbo].[Visit]  WITH CHECK ADD  CONSTRAINT [FK_Prescription_Visit] FOREIGN KEY([PrescriptionID])
REFERENCES [dbo].[Prescription] ([prescription_id])
GO
ALTER TABLE [dbo].[Visit] CHECK CONSTRAINT [FK_Prescription_Visit]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [CHK_PaymentType_Bill] CHECK  (([payment_type]='Cash' OR [payment_type]='Debit Card'))
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [CHK_PaymentType_Bill]
GO
ALTER TABLE [dbo].[BookAppointment]  WITH CHECK ADD  CONSTRAINT [CHK_Status_BAppointment] CHECK  (([status]='Canceled' OR [status]='Planed' OR [status]='Booked'))
GO
ALTER TABLE [dbo].[BookAppointment] CHECK CONSTRAINT [CHK_Status_BAppointment]
GO
ALTER TABLE [dbo].[Gender]  WITH CHECK ADD  CONSTRAINT [CHK_Gender] CHECK  (([gender_name]='MALE' OR [gender_name]='FEMALE'))
GO
ALTER TABLE [dbo].[Gender] CHECK CONSTRAINT [CHK_Gender]
GO
ALTER TABLE [dbo].[InventoryType]  WITH CHECK ADD  CONSTRAINT [CH_InventoryType] CHECK  (([inventory_type]='Store' OR [inventory_type]='WareHouse'))
GO
ALTER TABLE [dbo].[InventoryType] CHECK CONSTRAINT [CH_InventoryType]
GO
ALTER TABLE [dbo].[Occupation]  WITH CHECK ADD  CONSTRAINT [CHK_Occupation] CHECK  (([occupation_name]='Student' OR [occupation_name]='Employee' OR [occupation_name]='Unemployed'))
GO
ALTER TABLE [dbo].[Occupation] CHECK CONSTRAINT [CHK_Occupation]
GO
ALTER TABLE [dbo].[PackageType]  WITH CHECK ADD  CONSTRAINT [CH_Name_PackageType] CHECK  (([name]='Caplets' OR [name]='Tablets' OR [name]='Suppositories'))
GO
ALTER TABLE [dbo].[PackageType] CHECK CONSTRAINT [CH_Name_PackageType]
GO
ALTER TABLE [dbo].[Religion]  WITH CHECK ADD  CONSTRAINT [CHK_Religion] CHECK  (([name]='CHRISTIAN' OR [name]='MUSLIM' OR [name]='HINDUISM' OR [name]='OTHER'))
GO
ALTER TABLE [dbo].[Religion] CHECK CONSTRAINT [CHK_Religion]
GO
ALTER TABLE [dbo].[Visit]  WITH CHECK ADD  CONSTRAINT [CHK_Status_Visit] CHECK  (([status]='Canceled' OR [status]='Visited'))
GO
ALTER TABLE [dbo].[Visit] CHECK CONSTRAINT [CHK_Status_Visit]
GO
USE [master]
GO
ALTER DATABASE [Clinic] SET  READ_WRITE 
GO
