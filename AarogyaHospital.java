//package aarogya_hospital;

import java.util.*;


// the main class
public class AarogyaHospital {
  Scanner scanner = new Scanner(System.in);
  ArrayList<AarogyaMember> members = new ArrayList<>();

  public void addMember() {
    AarogyaMember newMember = new AarogyaMember();

    newMember.input();
    members.add(newMember);
  }

  public void displayMembers() {
    for (AarogyaMember member : members) {
      System.out.println("Patient ID: " + member.id);
      System.out.println("Patient Name: " + member.name);
      System.out.println("Patient Age: " + member.age);
      System.out.println("Patient Gender: " + member.gender);
      System.out.println("Patient Aadhar Card Number: " + member.aadharCardNumber);
      System.out.println("Patient Contact Number: " + member.contactNumber);
      System.out.println("Patient City: " + member.city);
      System.out.println("Patient Address: " + member.address);
      System.out.println("Patient Date of Admission: " + member.dateOfAdmission);
      System.out.println("Patient Guardian Name: " + member.guardianName);
      System.out.println("Patient Guardian Address: " + member.guardianAddress);
      System.out.println("Patient Guardian Contact Number: " + member.guardianContactNumber);
      System.out.println();
    }
  }
  public void searchMemberById(int id){
    for (AarogyaMember member : members) {
            if (member.getMemberId() == id) {
                System.out.println(member.getName() + " has the ID " + id);
                return; // Exit the method once a matching member is found
            }
        }
        // If no member with the specified ID is found, print an error message
        System.out.println("Member with ID " + id + " was not found.");
    }
  
  public void searchMemberFromCity(String city)throws NullPointerException{
    String noCity = null;
    for (AarogyaMember member : members) {
        if (member.getCity().equalsIgnoreCase(city)) {
            System.out.println(member.getName() + " is from " + city);
          return;
        }
    
    else {
            
            throw new NullPointerException("Member with city " + city + " not found.");
      
        }
    }
  }
  public void searchMemberFromParticularAgeGroup(){
 Scanner sc = new Scanner(System.in);
    int count=0;
        System.out.println("Enter Minimum age :");
        int minAge = sc.nextInt();
        System.out.println("Enter Maximum age :");
        int maxAge = sc.nextInt();
        // iterate through the array list to find patients in the given age group
        for (AarogyaMember member : members) {
            if (member.age >= minAge && member.age <= maxAge) {
                System.out.print(member.getName()+" ");
              count++;
            }
        }
    if(count>0){
      System.out.print("is of the required age group \n");
    }
    else{
      System.out.println("The age group your searching for is not present");
    }
            }
  public void recoveredInformation(){
    Scanner s = new Scanner(System.in);
        System.out.print("Enter patient ID: ");
        int id = s.nextInt();
    AarogyaMember mem=null;
    for (AarogyaMember member : members) {
            if (member.getId() == id) {
                mem = member;
                break;
            }
        }
    if (mem != null) {
            System.out.print("Has the patient recovered? (yes/no): ");
            String recoveredStr = s.next();
            boolean recovered = recoveredStr.equalsIgnoreCase("yes");
            mem.setRecovered(recovered);
            System.out.println("Recovered information updated for patient with ID " + mem.getId());
        } else {
            System.out.println("No patient found with ID " + id);
        }
  }
  public void deleteInformation(int patientId)throws NullPointerException{
   String patientToRemove = null;
    for (AarogyaMember member : members) {
            if (member.getMemberId() == patientId) {
                members.remove(member);
                System.out.println("Patient with ID " + patientId + " has been removed.");
                return;
            }
        }
        if (patientToRemove != null) {
            members.remove(patientToRemove);
            System.out.println("Patient with ID " + patientId + " has been removed.");
        } else {
            throw new NullPointerException("Patient with ID " + patientId + " not found.");
        }
    }
    
  

  // class for storing the patient information
  class AarogyaMember {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String aadharCardNumber;
    private String contactNumber;
    private String city;
    private String address;
    private String dateOfAdmission;
    private String guardianName;
    private String guardianAddress;
    private String guardianContactNumber;
    private boolean recovered;
    // declare all the details for the patient including name, age, gender, Aadhar
    // Card number, contact number, city, address, date of admission, guardian name,
    // guardian address, guardian contact number

    // make constructor for the class and assign it a unique Id
    /*
     * public AarogyaMember(int id, String name, int age, String gender, String
     * aadharCardNumber, String contactNumber, String city, String address, String
     * dateOfAdmission, String guardianName, String guardianAddress, String
     * guardianContactNumber) { this.id = id; this.name = name; this.age = age;
     * this.gender = gender; this.aadharCardNumber = aadharCardNumber;
     * this.contactNumber = contactNumber; this.city = city; this.address = address;
     * this.dateOfAdmission = dateOfAdmission; this.guardianName = guardianName;
     * this.guardianAddress = guardianAddress; this.guardianContactNumber =
     * guardianContactNumber; }
     */
     public int getMemberId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
public String getCity() {
        return city;
}
    public boolean isRecovered() {
        return recovered;
    }

    public void setRecovered(boolean recovered) {
        this.recovered = recovered;
    }
    
    // for taking patient information
    public void input() {
    boolean isUnique = false;
    while(!isUnique){
        System.out.println("Enter patient's Id: ");
        this.id = scanner.nextInt();
        isUnique = true;
        for(AarogyaMember member : members){
            if(member.id == this.id){
                System.out.println("Patient ID already exists. Please enter a unique ID.");
                isUnique = false;
                break;
            }
        }
    }
      System.out.println("Enter patient's name: ");
      scanner.nextLine();
      this.name = scanner.nextLine();
      while (true) {
        System.out.println("Enter patient's age: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
        if (age > 0 && age < 100) {
          break;
        } else {
          System.out.println("Invalid Age entered, Should contain 2 digits. Please try again.");
        }
      }

      System.out.println("Enter patient's gender: ");
      this.gender = scanner.nextLine();
      while (true) {
        System.out.println("Enter patient's Aadhar Card number: ");
        this.aadharCardNumber = scanner.nextLine();
        if (aadharCardNumber.length() == 12) {
          break;
        } else {
          System.out.println("Invalid Aadhar Card number entered, Should contain 12 digits. Please try again.");
        }
      }

      while (true) {
        System.out.println("Enter patient's contact number: ");
        this.contactNumber = scanner.nextLine();
        if (contactNumber.length() == 10) {
          break;
        } else {
          System.out.println("Invalid Contact number entered, Should contain 10 digits. Please try again.");
        }
      }

      System.out.println("Enter patient's city: ");
      this.city = scanner.nextLine();
      System.out.println("Enter patient's address: ");
      this.address = scanner.nextLine();
      System.out.println("Enter patient's date of admission: ");
      this.dateOfAdmission = scanner.nextLine();
      System.out.println("Enter patient's guardian name: ");
      this.guardianName = scanner.nextLine();
      System.out.println("Enter patient's guardian address: ");
      this.guardianAddress = scanner.nextLine();
       while (true) {
        System.out.println("Enter patient's guardian contact number: ");
        this.guardianContactNumber = scanner.nextLine();
        if (guardianContactNumber.length() == 10) {
          break;
        } else {
          System.out.println("Invalid Contact number entered, Should contain 10 digits. Please try again.");
        }
      }
    }
  }

  // pick the choice of task to be performed
  static long choices() {
    System.out.println(" "); 
    System.out.println("Press 1 for adding new member");
    System.out.println("Press 2 to view list of all available members");
    System.out.println("Press 3 to search member by ID");
    System.out.println("Press 4 to search member from a particular city");
    System.out.println("Press 5 to search member from a particular age group");
    System.out.println("Press 6 to mark recovery of a member");
    System.out.println("Press 7 to delete data of a member");
    System.out.println("Press 0 to exit");

    Scanner ip = new Scanner(System.in); // create scanner class to take input
    long option = ip.nextLong();
    return option;
  }

  public static void main(String args[]) {
    // ArrayList<AarogyaMember> members = new ArrayList<>();
    // initialise array list to store list of patients information
    AarogyaHospital hospital = new AarogyaHospital();
    // for adding aarogya member information
    while (true) {

      // take choice
      long option = choices();

      // invalid choice
      if (option < 0 || option > 7) {
        System.out.println("Invalid choice");
      }
      // take the input and add in the arrayList
      else if (option == 1) {
        hospital.addMember();
      }
      // iterate and print all the patients information
      else if (option == 2) {
        hospital.displayMembers();
      }

      // print details of the patient with a particular id (take id as input)
      else if (option == 3) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the Id to search:");
        hospital.searchMemberById(s.nextInt());
      }

      // to print all the patients from a particular city (take city as input)
      else if (option == 4) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the city name to search:");
        hospital.searchMemberFromCity(s.next());
      }
      // to print details of all the patients in a particular age group (take age
      // limits as input)
      else if (option == 5) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter to check for particular age group(ex:18,30):");
        hospital.searchMemberFromParticularAgeGroup();
      }
      // take member id as input to maintain recovered information of patient
      else if (option == 6) {
        hospital.recoveredInformation();
      }
      // take member id as input to delete patient information
      else if (option == 7) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Id to delete information:");
        hospital.deleteInformation(s.nextInt());
      }

      else {
        System.out.println("Thank you!!!!");
        break;
      }
    }

  }
}