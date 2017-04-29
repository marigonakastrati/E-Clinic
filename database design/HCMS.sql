USE [master]
GO
/****** Object:  Database [Clinic]    Script Date: 4/29/2017 3:30:02 PM ******/
CREATE DATABASE [Clinic]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Clinic', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Clinic.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Clinic_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Clinic_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
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
/****** Object:  User [Clinic]    Script Date: 4/29/2017 3:30:02 PM ******/
CREATE USER [Clinic] FOR LOGIN [Clinic] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [Clinic]
GO
/****** Object:  Table [dbo].[AdminClinic]    Script Date: 4/29/2017 3:30:03 PM ******/
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
/****** Object:  Table [dbo].[Alergis]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alergis](
	[medicine_id] [int] NOT NULL,
	[severity] [varchar](255) NULL,
	[reaction] [varchar](255) NULL,
	[date_of_onset] [date] NULL,
	[alergie_id] [int] NOT NULL,
	[patient_id] [int] NOT NULL,
 CONSTRAINT [PK_alergie_id] PRIMARY KEY CLUSTERED 
(
	[alergie_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Bill]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[bill_id] [int] NOT NULL,
	[amount] [decimal](10, 2) NULL,
	[payment_type] [varchar](25) NULL,
 CONSTRAINT [PK_bill_id] PRIMARY KEY CLUSTERED 
(
	[bill_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BillPayment]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillPayment](
	[bill_id] [int] NOT NULL,
	[receptionist_id] [int] NOT NULL,
	[patient_id] [int] NOT NULL,
	[visit_id] [int] NOT NULL,
	[date_of_payment] [date] NOT NULL,
	[bill_payment_id] [int] NOT NULL,
 CONSTRAINT [PK_bill_payment_id] PRIMARY KEY CLUSTERED 
(
	[bill_payment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookAppointment]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookAppointment](
	[book_id] [int] NOT NULL,
	[schedule_id] [int] NOT NULL,
	[patient_id] [int] NOT NULL,
	[date_booked] [date] NULL,
	[time_booked] [time](7) NULL,
	[status] [varchar](20) NULL,
 CONSTRAINT [PK_bookAppontment_id] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Contact]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[person_id] [int] NOT NULL,
	[contact_id] [int] NOT NULL,
	[type] [char](10) NULL,
	[value] [nvarchar](20) NULL,
 CONSTRAINT [PK_contact_id] PRIMARY KEY CLUSTERED 
(
	[contact_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Doctor]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctor](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[doctor_id] [int] IDENTITY(50000000,1) NOT NULL,
 CONSTRAINT [PK_doctor_id] PRIMARY KEY CLUSTERED 
(
	[doctor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Education]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Education](
	[education_id] [int] NOT NULL,
	[institution_name] [varchar](25) NULL,
	[education_type_id] [int] NOT NULL,
	[education_program_id] [int] NOT NULL,
 CONSTRAINT [PK_education_id] PRIMARY KEY CLUSTERED 
(
	[education_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EducationProgram]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EducationProgram](
	[education_program_id] [int] NOT NULL,
	[program_name] [varchar](50) NULL,
 CONSTRAINT [PK_education_program_id] PRIMARY KEY CLUSTERED 
(
	[education_program_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EducationType]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EducationType](
	[education_type_id] [int] NOT NULL,
	[education_name] [varchar](25) NULL,
 CONSTRAINT [PK_typet_id] PRIMARY KEY CLUSTERED 
(
	[education_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Emergency_Information]    Script Date: 4/29/2017 3:30:03 PM ******/
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
/****** Object:  Table [dbo].[Gender]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gender](
	[gender_id] [int] NOT NULL,
	[gender_name] [char](6) NULL,
 CONSTRAINT [PK_gender_id] PRIMARY KEY CLUSTERED 
(
	[gender_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Guardian]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Guardian](
	[parent_id] [int] NOT NULL,
	[child_id] [int] NOT NULL,
	[guardian_id] [int] NOT NULL,
 CONSTRAINT [PK_guardian_id] PRIMARY KEY CLUSTERED 
(
	[guardian_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HRManager]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HRManager](
	[person_id] [int] NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[manager_id] [int] IDENTITY(50700000,1) NOT NULL,
 CONSTRAINT [PK_manager_id] PRIMARY KEY CLUSTERED 
(
	[manager_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Medicine]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicine](
	[medicine_id] [int] NOT NULL,
	[medicine_name] [nvarchar](20) NULL,
	[package_type] [nvarchar](20) NULL,
	[weight] [int] NULL,
	[price] [decimal](5, 2) NULL,
	[pharmacy_manager_id] [int] NOT NULL,
 CONSTRAINT [PK_medicine_id] PRIMARY KEY CLUSTERED 
(
	[medicine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Nurse]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nurse](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[nurse_id] [int] IDENTITY(50100000,1) NOT NULL,
 CONSTRAINT [PK_nurse_id] PRIMARY KEY CLUSTERED 
(
	[nurse_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Order]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[patient_id] [int] NOT NULL,
	[pharmacist_id] [int] NOT NULL,
	[prescription_id] [int] NOT NULL,
	[total_price] [decimal](5, 2) NULL,
	[order_id] [int] NOT NULL,
	[date_ordered] [date] NOT NULL,
 CONSTRAINT [PK_order_id] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderItem]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderItem](
	[order_item_id] [int] NOT NULL,
	[medicine_id] [int] NOT NULL,
	[order_id] [int] NOT NULL,
 CONSTRAINT [PK_order_item_id] PRIMARY KEY CLUSTERED 
(
	[order_item_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Patient]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patient](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[patient_id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_patient_id] PRIMARY KEY CLUSTERED 
(
	[patient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Person]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Person](
	[person_id] [int] NOT NULL,
	[first_name] [varchar](20) NULL,
	[middle_name] [varchar](20) NULL,
	[last_name] [varchar](20) NULL,
	[dob] [date] NULL,
	[birth_state] [varchar](15) NULL,
	[birth_town] [varchar](20) NULL,
	[gender_id] [int] NOT NULL,
	[occupation] [varchar](20) NULL,
	[nationalty] [varchar](10) NULL,
	[ethnic_origin] [varchar](10) NULL,
	[marital_statuss] [varchar](15) NULL,
	[country] [varchar](10) NULL,
	[post_code] [char](5) NULL,
	[religion_ID] [int] NULL,
 CONSTRAINT [PK_person_id] PRIMARY KEY CLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PersonEducation]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PersonEducation](
	[person_id] [int] NOT NULL,
	[education_id] [int] NOT NULL,
	[date_start] [date] NULL,
	[date_end] [date] NULL,
	[person_education_id] [int] NOT NULL,
 CONSTRAINT [PK_person_education_id] PRIMARY KEY CLUSTERED 
(
	[person_education_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pharmacist]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pharmacist](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[pharmacist_id] [int] IDENTITY(50200000,1) NOT NULL,
 CONSTRAINT [PK_pharmacist_id] PRIMARY KEY CLUSTERED 
(
	[pharmacist_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pharmacy_Manager]    Script Date: 4/29/2017 3:30:03 PM ******/
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
/****** Object:  Table [dbo].[Prescription]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prescription](
	[prescription_id] [int] NOT NULL,
	[comment/desc] [text] NULL,
 CONSTRAINT [PK_prescription_id] PRIMARY KEY CLUSTERED 
(
	[prescription_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PrescriptionMedicines]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PrescriptionMedicines](
	[prescription_id] [int] NOT NULL,
	[medicine_id] [int] NOT NULL,
	[prescribed_medicine_id] [int] NOT NULL,
	[days_to_use] [int] NOT NULL,
	[times_per_day] [int] NOT NULL,
	[comment] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_prescribed_medicine_id] PRIMARY KEY CLUSTERED 
(
	[prescribed_medicine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Receptionist]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Receptionist](
	[person_id] [int] NOT NULL,
	[pass_code] [nvarchar](256) NOT NULL,
	[receptionist_id] [int] IDENTITY(50400000,1) NOT NULL,
 CONSTRAINT [PK_receptionist_id] PRIMARY KEY CLUSTERED 
(
	[receptionist_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Religion]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Religion](
	[religion_ID] [int] NOT NULL,
	[name] [varchar](20) NULL,
 CONSTRAINT [PK_religion_id] PRIMARY KEY CLUSTERED 
(
	[religion_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Schedule]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schedule](
	[schedule_id] [int] NOT NULL,
	[doctor_id] [int] NOT NULL,
	[status] [varchar](20) NULL,
	[date_start] [date] NULL,
	[date_end] [date] NULL,
	[time_start] [time](7) NULL,
	[time_end] [time](7) NULL,
	[manager_id] [int] NOT NULL,
 CONSTRAINT [PK_schedule_id] PRIMARY KEY CLUSTERED 
(
	[schedule_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Visit]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Visit](
	[visit_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[prescription_id] [int] NOT NULL,
	[date_time_start] [date] NULL,
	[date_time_end] [date] NULL,
	[status] [varchar](20) NULL,
 CONSTRAINT [PK_visit_id] PRIMARY KEY CLUSTERED 
(
	[visit_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Vitals]    Script Date: 4/29/2017 3:30:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vitals](
	[vital_taken] [nvarchar](20) NULL,
	[bp] [decimal](5, 2) NULL,
	[hr] [decimal](5, 2) NULL,
	[rr] [decimal](5, 2) NULL,
	[ht/lt] [decimal](5, 2) NULL,
	[wt] [decimal](5, 2) NULL,
	[bmi] [decimal](5, 2) NULL,
	[comment] [varchar](50) NULL,
	[patient_id] [int] NOT NULL,
	[vital_id] [int] NOT NULL,
	[date_taken] [date] NOT NULL,
 CONSTRAINT [PK_vital_id] PRIMARY KEY CLUSTERED 
(
	[vital_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[AdminClinic] ON 

INSERT [dbo].[AdminClinic] ([person_id], [pass_code], [admin_clinic_id]) VALUES (1234569788, N'e10adc3949ba59abbe56e057f20f883e', 50500000)
SET IDENTITY_INSERT [dbo].[AdminClinic] OFF
INSERT [dbo].[Contact] ([person_id], [contact_id], [type], [value]) VALUES (1234569788, 1, N'MOB       ', N'049-123-456')
SET IDENTITY_INSERT [dbo].[Doctor] ON 

INSERT [dbo].[Doctor] ([person_id], [pass_code], [doctor_id]) VALUES (1234569788, N'123', 50000000)
SET IDENTITY_INSERT [dbo].[Doctor] OFF
INSERT [dbo].[Education] ([education_id], [institution_name], [education_type_id], [education_program_id]) VALUES (1, N'UBT', 1, 1)
INSERT [dbo].[EducationProgram] ([education_program_id], [program_name]) VALUES (1, N'Computer Science')
INSERT [dbo].[EducationType] ([education_type_id], [education_name]) VALUES (1, N'BACHELOR')
INSERT [dbo].[EducationType] ([education_type_id], [education_name]) VALUES (2, N'MASTER')
INSERT [dbo].[EducationType] ([education_type_id], [education_name]) VALUES (3, N'PHD')
INSERT [dbo].[EducationType] ([education_type_id], [education_name]) VALUES (4, N'HIGH SCHOOL')
INSERT [dbo].[EducationType] ([education_type_id], [education_name]) VALUES (5, N'CERTIFICATE')
INSERT [dbo].[Gender] ([gender_id], [gender_name]) VALUES (1, N'MALE  ')
INSERT [dbo].[Gender] ([gender_id], [gender_name]) VALUES (2, N'FEMALE')
SET IDENTITY_INSERT [dbo].[HRManager] ON 

INSERT [dbo].[HRManager] ([person_id], [pass_code], [manager_id]) VALUES (1234569788, N'123', 50700000)
SET IDENTITY_INSERT [dbo].[HRManager] OFF
SET IDENTITY_INSERT [dbo].[Nurse] ON 

INSERT [dbo].[Nurse] ([person_id], [pass_code], [nurse_id]) VALUES (1234569788, N'123', 50100000)
SET IDENTITY_INSERT [dbo].[Nurse] OFF
SET IDENTITY_INSERT [dbo].[Patient] ON 

INSERT [dbo].[Patient] ([person_id], [pass_code], [patient_id]) VALUES (1234569788, N'123', 1)
SET IDENTITY_INSERT [dbo].[Patient] OFF
INSERT [dbo].[Person] ([person_id], [first_name], [middle_name], [last_name], [dob], [birth_state], [birth_town], [gender_id], [occupation], [nationalty], [ethnic_origin], [marital_statuss], [country], [post_code], [religion_ID]) VALUES (1234569788, N'Fatlonder', NULL, N'Cakolli', CAST(N'2000-02-02' AS Date), N'Prishtine', N'Prishtine', 1, N'Student', N'Albanina', N'Albanina', NULL, N'Kosovo', N'101  ', NULL)
INSERT [dbo].[PersonEducation] ([person_id], [education_id], [date_start], [date_end], [person_education_id]) VALUES (1234569788, 1, CAST(N'2015-01-10' AS Date), CAST(N'2018-01-06' AS Date), 1)
SET IDENTITY_INSERT [dbo].[Pharmacist] ON 

INSERT [dbo].[Pharmacist] ([person_id], [pass_code], [pharmacist_id]) VALUES (1234569788, N'123', 50200000)
SET IDENTITY_INSERT [dbo].[Pharmacist] OFF
SET IDENTITY_INSERT [dbo].[Pharmacy_Manager] ON 

INSERT [dbo].[Pharmacy_Manager] ([person_id], [pass_code], [pharmacy_manager_id]) VALUES (1234569788, N'123', 50300000)
SET IDENTITY_INSERT [dbo].[Pharmacy_Manager] OFF
SET IDENTITY_INSERT [dbo].[Receptionist] ON 

INSERT [dbo].[Receptionist] ([person_id], [pass_code], [receptionist_id]) VALUES (1234569788, N'123', 50400000)
SET IDENTITY_INSERT [dbo].[Receptionist] OFF
/****** Object:  Index [UQ_Per_Clin_Admin]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[AdminClinic] ADD  CONSTRAINT [UQ_Per_Clin_Admin] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Medicine_Patient_Alergis]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Alergis] ADD  CONSTRAINT [UQ_Medicine_Patient_Alergis] UNIQUE NONCLUSTERED 
(
	[medicine_id] ASC,
	[patient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Visit_BillPayment]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[BillPayment] ADD  CONSTRAINT [UQ_Visit_BillPayment] UNIQUE NONCLUSTERED 
(
	[visit_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Schedule_BookAppointment]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[BookAppointment] ADD  CONSTRAINT [UQ_Schedule_BookAppointment] UNIQUE NONCLUSTERED 
(
	[schedule_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Contact]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Contact] ADD  CONSTRAINT [UQ_Per_Contact] UNIQUE NONCLUSTERED 
(
	[person_id] ASC,
	[contact_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Doc]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Doctor] ADD  CONSTRAINT [UQ_Per_Doc] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_EducationType_EducationProgram_Education]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Education] ADD  CONSTRAINT [UQ_EducationType_EducationProgram_Education] UNIQUE NONCLUSTERED 
(
	[education_type_id] ASC,
	[education_program_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Person_Patient_EmergencyContact]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Emergency_Information] ADD  CONSTRAINT [UQ_Person_Patient_EmergencyContact] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Person_Child_Guardian]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Guardian] ADD  CONSTRAINT [UQ_Person_Child_Guardian] UNIQUE NONCLUSTERED 
(
	[parent_id] ASC,
	[child_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_HRMan]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[HRManager] ADD  CONSTRAINT [UQ_Per_HRMan] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_PhaManager_Medicine]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Medicine] ADD  CONSTRAINT [UQ_PhaManager_Medicine] UNIQUE NONCLUSTERED 
(
	[medicine_id] ASC,
	[pharmacy_manager_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Nur]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Nurse] ADD  CONSTRAINT [UQ_Per_Nur] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Pharmacist_Prescription_Order]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Order] ADD  CONSTRAINT [UQ_Patient_Pharmacist_Prescription_Order] UNIQUE NONCLUSTERED 
(
	[patient_id] ASC,
	[pharmacist_id] ASC,
	[prescription_id] ASC,
	[date_ordered] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Medicine_Order_OrderItem]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[OrderItem] ADD  CONSTRAINT [UQ_Medicine_Order_OrderItem] UNIQUE NONCLUSTERED 
(
	[medicine_id] ASC,
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Pat]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Patient] ADD  CONSTRAINT [UQ_Per_Pat] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Education_Person_PersonEducation]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[PersonEducation] ADD  CONSTRAINT [UQ_Education_Person_PersonEducation] UNIQUE NONCLUSTERED 
(
	[education_id] ASC,
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Phar]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Pharmacist] ADD  CONSTRAINT [UQ_Per_Phar] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Phar_Man]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Pharmacy_Manager] ADD  CONSTRAINT [UQ_Per_Phar_Man] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ_Medicine_Prescription_Comment_PrescriptionMedicines]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[PrescriptionMedicines] ADD  CONSTRAINT [UQ_Medicine_Prescription_Comment_PrescriptionMedicines] UNIQUE NONCLUSTERED 
(
	[medicine_id] ASC,
	[prescription_id] ASC,
	[comment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Per_Rec]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Receptionist] ADD  CONSTRAINT [UQ_Per_Rec] UNIQUE NONCLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Doc_Man_Schedule_date_time]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Schedule] ADD  CONSTRAINT [UQ_Doc_Man_Schedule_date_time] UNIQUE NONCLUSTERED 
(
	[manager_id] ASC,
	[doctor_id] ASC,
	[date_start] ASC,
	[date_end] ASC,
	[time_start] ASC,
	[time_end] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ_Patient_Date_Vitals]    Script Date: 4/29/2017 3:30:03 PM ******/
ALTER TABLE [dbo].[Vitals] ADD  CONSTRAINT [UQ_Patient_Date_Vitals] UNIQUE NONCLUSTERED 
(
	[date_taken] ASC,
	[patient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[AdminClinic]  WITH CHECK ADD  CONSTRAINT [FK_Per_Clin_Admin] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[AdminClinic] CHECK CONSTRAINT [FK_Per_Clin_Admin]
GO
ALTER TABLE [dbo].[Alergis]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_Alergies] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[Medicine] ([medicine_id])
GO
ALTER TABLE [dbo].[Alergis] CHECK CONSTRAINT [FK_Medicine_Alergies]
GO
ALTER TABLE [dbo].[Alergis]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Alergies] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[Alergis] CHECK CONSTRAINT [FK_Patient_Alergies]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Bill_BillPayment] FOREIGN KEY([bill_id])
REFERENCES [dbo].[Bill] ([bill_id])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Bill_BillPayment]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Patient_BillPayment] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Patient_BillPayment]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Receptionist_BillPayment] FOREIGN KEY([receptionist_id])
REFERENCES [dbo].[Receptionist] ([receptionist_id])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Receptionist_BillPayment]
GO
ALTER TABLE [dbo].[BillPayment]  WITH CHECK ADD  CONSTRAINT [FK_Visit_BillPayment] FOREIGN KEY([visit_id])
REFERENCES [dbo].[Visit] ([visit_id])
GO
ALTER TABLE [dbo].[BillPayment] CHECK CONSTRAINT [FK_Visit_BillPayment]
GO
ALTER TABLE [dbo].[BookAppointment]  WITH CHECK ADD  CONSTRAINT [FK_Patient_BookAppointment] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[BookAppointment] CHECK CONSTRAINT [FK_Patient_BookAppointment]
GO
ALTER TABLE [dbo].[BookAppointment]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_BookAppointment] FOREIGN KEY([schedule_id])
REFERENCES [dbo].[Schedule] ([schedule_id])
GO
ALTER TABLE [dbo].[BookAppointment] CHECK CONSTRAINT [FK_Schedule_BookAppointment]
GO
ALTER TABLE [dbo].[Contact]  WITH CHECK ADD  CONSTRAINT [FK_Per_Contact] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Contact] CHECK CONSTRAINT [FK_Per_Contact]
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD  CONSTRAINT [FK_Per_Doc] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Doctor] CHECK CONSTRAINT [FK_Per_Doc]
GO
ALTER TABLE [dbo].[Education]  WITH CHECK ADD  CONSTRAINT [FK_EducationProgram_Education] FOREIGN KEY([education_program_id])
REFERENCES [dbo].[EducationProgram] ([education_program_id])
GO
ALTER TABLE [dbo].[Education] CHECK CONSTRAINT [FK_EducationProgram_Education]
GO
ALTER TABLE [dbo].[Education]  WITH CHECK ADD  CONSTRAINT [FK_EducationType_Education] FOREIGN KEY([education_type_id])
REFERENCES [dbo].[EducationType] ([education_type_id])
GO
ALTER TABLE [dbo].[Education] CHECK CONSTRAINT [FK_EducationType_Education]
GO
ALTER TABLE [dbo].[Emergency_Information]  WITH CHECK ADD  CONSTRAINT [FK_Patient_EmergencyContact] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[Emergency_Information] CHECK CONSTRAINT [FK_Patient_EmergencyContact]
GO
ALTER TABLE [dbo].[Emergency_Information]  WITH CHECK ADD  CONSTRAINT [FK_Person_EmergencyContact] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Emergency_Information] CHECK CONSTRAINT [FK_Person_EmergencyContact]
GO
ALTER TABLE [dbo].[Guardian]  WITH CHECK ADD  CONSTRAINT [FK_child_Guardian] FOREIGN KEY([child_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Guardian] CHECK CONSTRAINT [FK_child_Guardian]
GO
ALTER TABLE [dbo].[Guardian]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Guardian] FOREIGN KEY([parent_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Guardian] CHECK CONSTRAINT [FK_Patient_Guardian]
GO
ALTER TABLE [dbo].[HRManager]  WITH CHECK ADD  CONSTRAINT [FK_Per_HRMan] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[HRManager] CHECK CONSTRAINT [FK_Per_HRMan]
GO
ALTER TABLE [dbo].[Medicine]  WITH CHECK ADD  CONSTRAINT [FK_PharmacyManager_Medicine] FOREIGN KEY([pharmacy_manager_id])
REFERENCES [dbo].[Pharmacy_Manager] ([pharmacy_manager_id])
GO
ALTER TABLE [dbo].[Medicine] CHECK CONSTRAINT [FK_PharmacyManager_Medicine]
GO
ALTER TABLE [dbo].[Nurse]  WITH CHECK ADD  CONSTRAINT [FK_Per_Nur] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Nurse] CHECK CONSTRAINT [FK_Per_Nur]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Orders] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Patient_Orders]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Pharmacist_Orders] FOREIGN KEY([pharmacist_id])
REFERENCES [dbo].[Pharmacist] ([pharmacist_id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Pharmacist_Orders]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Prescription_Orders] FOREIGN KEY([prescription_id])
REFERENCES [dbo].[Prescription] ([prescription_id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Prescription_Orders]
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_OrderItem] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[Medicine] ([medicine_id])
GO
ALTER TABLE [dbo].[OrderItem] CHECK CONSTRAINT [FK_Medicine_OrderItem]
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD  CONSTRAINT [FK_Order_OrderItem] FOREIGN KEY([order_id])
REFERENCES [dbo].[Order] ([order_id])
GO
ALTER TABLE [dbo].[OrderItem] CHECK CONSTRAINT [FK_Order_OrderItem]
GO
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Per_Pat] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Per_Pat]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Gender_Per] FOREIGN KEY([gender_id])
REFERENCES [dbo].[Gender] ([gender_id])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Gender_Per]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Religion_Per] FOREIGN KEY([religion_ID])
REFERENCES [dbo].[Religion] ([religion_ID])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Religion_Per]
GO
ALTER TABLE [dbo].[PersonEducation]  WITH CHECK ADD  CONSTRAINT [FK_Education_PersonEducation] FOREIGN KEY([education_id])
REFERENCES [dbo].[Education] ([education_id])
GO
ALTER TABLE [dbo].[PersonEducation] CHECK CONSTRAINT [FK_Education_PersonEducation]
GO
ALTER TABLE [dbo].[PersonEducation]  WITH CHECK ADD  CONSTRAINT [FK_Person_PersonEducation] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[PersonEducation] CHECK CONSTRAINT [FK_Person_PersonEducation]
GO
ALTER TABLE [dbo].[Pharmacist]  WITH CHECK ADD  CONSTRAINT [FK_Per_Phar] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Pharmacist] CHECK CONSTRAINT [FK_Per_Phar]
GO
ALTER TABLE [dbo].[Pharmacy_Manager]  WITH CHECK ADD  CONSTRAINT [FK_Per_Phar_Man] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Pharmacy_Manager] CHECK CONSTRAINT [FK_Per_Phar_Man]
GO
ALTER TABLE [dbo].[PrescriptionMedicines]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_PrescriptionMedicines] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[Medicine] ([medicine_id])
GO
ALTER TABLE [dbo].[PrescriptionMedicines] CHECK CONSTRAINT [FK_Medicine_PrescriptionMedicines]
GO
ALTER TABLE [dbo].[PrescriptionMedicines]  WITH CHECK ADD  CONSTRAINT [FK_Prescription_PrescriptionMedicines] FOREIGN KEY([prescription_id])
REFERENCES [dbo].[Prescription] ([prescription_id])
GO
ALTER TABLE [dbo].[PrescriptionMedicines] CHECK CONSTRAINT [FK_Prescription_PrescriptionMedicines]
GO
ALTER TABLE [dbo].[Receptionist]  WITH CHECK ADD  CONSTRAINT [FK_Per_Rec] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Receptionist] CHECK CONSTRAINT [FK_Per_Rec]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Doc_Schedule] FOREIGN KEY([doctor_id])
REFERENCES [dbo].[Doctor] ([doctor_id])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Doc_Schedule]
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Man_Schedule] FOREIGN KEY([manager_id])
REFERENCES [dbo].[HRManager] ([manager_id])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Man_Schedule]
GO
ALTER TABLE [dbo].[Visit]  WITH CHECK ADD  CONSTRAINT [FK_BookAppointment_Visit] FOREIGN KEY([book_id])
REFERENCES [dbo].[BookAppointment] ([book_id])
GO
ALTER TABLE [dbo].[Visit] CHECK CONSTRAINT [FK_BookAppointment_Visit]
GO
ALTER TABLE [dbo].[Visit]  WITH CHECK ADD  CONSTRAINT [FK_Prescription_Visit] FOREIGN KEY([prescription_id])
REFERENCES [dbo].[Prescription] ([prescription_id])
GO
ALTER TABLE [dbo].[Visit] CHECK CONSTRAINT [FK_Prescription_Visit]
GO
ALTER TABLE [dbo].[Vitals]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Vitals] FOREIGN KEY([patient_id])
REFERENCES [dbo].[Patient] ([patient_id])
GO
ALTER TABLE [dbo].[Vitals] CHECK CONSTRAINT [FK_Patient_Vitals]
GO
USE [master]
GO
ALTER DATABASE [Clinic] SET  READ_WRITE 
GO
