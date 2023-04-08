# FaceAuthenticationHospital


Created a patient registration App that aims to simplify the patient registration process and enhance security by utilizing facial recognition technology.
This app allows patients to securely upload their personal information and scanned photo fromt heir homes,eliminating the need for in-person registration at the hospital.
Upon the patient's arrival at the hospital, the facial recognition technology will quickly and accurately verify their identity
against the registration information already stored in the app
database. 
The use of facial recognition technology will enhance security measures by ensuring that only the registered patient is present at the hospital, and a token can be issued for queuing outside the relevant room. 

This solution should provide a convenient and secure alternative to traditional registration methods, improving the patient experience and enabling healthcare providers to deliver care more efficiently.

# Open in android studio

Clone the repository using git clone https://github.com/:Savinwc/FaceAuthenticationHospital.git  OR Download ZIP of this project (under the 'Code' button on this page) and unzip to a folder.

In android studio, go to File -> Import Project then choose this project folder and then click Next -> Finish.

# Implementation

The following is how some of the most important parts of the app was implemented.

* Face authentication consists both real time face detection as well as photo
* Sign-Up/Login using email address and password using firebase authentication as the backend. Unique id generated for each user account by FirebaseAuth is used      to  save user info (such as account details, and messages sent) in Firebase Realtime Database. (user's node is set as unique id).Face Authentication used by Google ML Kit
 Face  data is stored in binary format in MS SQL Server.
* User can book an appointment with the doctor concerned. A token number is generated and issued to the patient containing doctor room details and token number
* Hospital admin can confirm the user by selecting token and scanning face of the patient at the hospital if the face is not same it will show unrecognised face, if
  face is recognised user can go to the queue outside the relevant room.
* Implemented a chatbot and admin dashboard to check doctor and patients details and appointments respectively.
<p float="left">
<img src=https://user-images.githubusercontent.com/93364152/230717362-dff410e6-746f-49ed-93ed-40e3721e5a85.jpg width=20% height=20%>
<img src=https://user-images.githubusercontent.com/93364152/230717363-aef24b8f-42d4-4160-a66e-f82e3b8f4f2a.jpg width=20% height=20%>
<img src=https://user-images.githubusercontent.com/93364152/230717364-977b3778-8ae8-4c2c-b0b1-2eb50faa9d9b.jpg  width=20% height=20%>
<img src=https://user-images.githubusercontent.com/93364152/230717607-a9abcbe0-50db-4a12-99a4-877c12b98042.jpg  width=20% height=20%>
<img src=https://user-images.githubusercontent.com/93364152/230717614-e8ee7e48-dc9b-45e4-a0b6-704dc8a7dbfe.jpg  width=20% height=20%>
</p>

#Contributors

@Savinwc
@AshwinJenu

