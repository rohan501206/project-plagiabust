/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedList;
import reportingModule.DiffMatch.Diff;

/**
 *
 * @author user
 */
public class TestMain {



    public static void main(String[] args){

        // s= " MPR Duplicate Report Identification module    Software Architecture Document   Date:  20/OCT/2009   Date Version Description Author         MPR Duplicate Report Identification module   Version:           1.0 070188T-Architecture.pdf Confidential University of Moratuwa, 2009 Page 3 of 9 Table of Contents 1.1 Purpose 4 1.3 Definitions, Acronyms, and Abbreviations 4 2. Architectural Representation 4 4. Use-Case View 5 4.2 Use cases 6 4.2.2 Viewing the results 6 4.2.4 Confirming a result 6 4.2.6 Exiting the DRI module 6 5.1 Overview 7 6. Implementation View 8 6.2 Layers 8 Software Architecture Document   Date:  20/OCT/2009   1. Introduction information in a disaster situation. The Missing Person Registry of SAHANA system records all information about duplicate missing reports and enabling the user to eliminate them after a review. 1.1 Purpose architectural views to depict different aspects of the system. It is intended to capture and convey the significant communicate the architecture of the MPR Duplicate Report Identification module to the end users as well as the  Duplicate Report Identification module is a separate feature of the MPR of the SAHANA system and it view of the DRI module. 1.3 Definitions, Acronyms, and Abbreviations o DRI – Duplicate Report Identification 1.4 Overview o Architectural representation section- describes what software architecture is used for the system and o Architectural goals and constraints section- describes the software requirements and objectives that have o Use-case view, Logical view and Implementation view sections – describes the architecture of the  2. Architectural Representation  architecture. This document includes only the following views. user and the functionality of the system. o Implementation view: Describes the overall structure of the implementation model, the decomposition significant components.  Software Architecture Document   Date:  20/OCT/2009   The MPR DRI module includes following software requirements and constraints which will affect the o The architecture of the DRI module should follow the current architecture of the SAHANA system.  o The DRI module shall be able to run the algorithm which identifies the duplicate reports, on the MPR o The flow of functional activities shall not be complex and a user shall be able to adhere to that in less    4.1 Actors stated in the use case diagram.   MPR Duplicate Report Identification module   Version:           1.0 070188T-Architecture.pdf Confidential University of Moratuwa, 2009 Page 6 of 9 4.2 Use cases  The user is able to run the DRI module when he/she needs to eliminate the duplicate reports in the MPR. When the the MPR. 4.2.2 Viewing the results view and compare the results. 4.2.3 Navigating through the results them. 4.2.4 Confirming a result   pair as identical.  4.2.5 Eliminating a result the reports from the suggested pair.  4.2.6 Exiting the DRI module            Software Architecture Document   Date:  20/OCT/2009   5.1 Overview Application Framework at the core, and surrounded by libraries and APIs. This in turn is wrapped by a set of Framework and libraries. The architecture is depicted as a layered diagram, where outer layers have the ability to The DRI module is included inside the MPR module since it is a feature of the MPR. The DRI module also                5.2 Architecturally Significant Design Packages This framework is written in PHP and it is a generic framework for ease of development and synchronize system tasks and events. It also supports for security at the modular and framework level and  This module captures information about missing people, the people who report them to be missing, in their search. MPR Duplicate Report Identification module   Version:           1.0 070188T-Architecture.pdf Confidential University of Moratuwa, 2009 Page 8 of 9 o DRI module missing reports in the MPR. It is to be built on top of the SAHANA Application Framework and libraries.  6.1 Overview              o Presentation Layer This has two interfaces as the RUN button and the main interface.  Button to run the DRI MPR. The user will be able to run the module by clicking on this button. When the user runs the results.  Main interface the results in pairs and will provide the capability for the users to navigate through the results,  MPR Duplicate Report Identification module   Version:           1.0 070188T-Architecture.pdf Confidential University of Moratuwa, 2009 Page 9 of 9 o Business Layer functional logics.  Duplicate identifying logic the user runs the module by clicking on the run button this logic will run an algorithm to identify the  This logic is responsible for viewing the results of the duplicate identifying logic and will also enable  When user needs to confirm a suggested result as identical reports, this logic will handle that function.  This logic is responsible for the elimination of reports after a user’s review. It will eliminate the reports  This layer includes the Missing reports repository and the Duplicate reports repository. The Missing need not to be implemented. The Duplicate reports repository will be generated when the user runs the This is not a permanent repository and hence should be discarded when exiting the DRI module.    null";
        //String s = "Siya Bas SaranaVersion <1.0>Software Architecture Document   Date:  22. Oct. 2009Revision History22. Oct. 2009 1.0 Initial Version Keheliya GallabaSiya Bas Sarana   Version:           <1.0>SiyaBasSaranaSAD1. Introduction 41.2 Scope 41.4 References 42. Architectural Representation 44. Use-Case View 55. Logical View 75.2 Architecturally Significant Design Packages 76. Process View 87. Implementation View 99.. Quality 9Siya Bas Sarana   Version:           <1.0>SiyaBasSaranaSAD1.IntroductionThis document provides a comprehensive architectural overview of the system, using a number of different significant architectural decisions which have been made on the system.This Software Architecture Document provides an architectural overview of the firefox extension, Siya Bas to convert text to Sinhala/Tamil Unicode as you type without any copy/paste from external sites and view Project module of Bsc (Computer Science and Engineering) degree course of University of Moratuwa.Firefox - a free and open source web browser descended from the Mozilla Application Suite and managed Extensions - Add-ons which add new functionality to Mozilla applications such as Firefox, SeaMonkey and XUL -  (pronounced  ) 1.4ReferencesHitchner of University of Victoria, CanadaLifeHacker.com - http://lifehacker.com/264490/how-to-build-a-Firefox-extension Mozilla Developer Center - https://developer.mozilla.org/En http://www.ucsc.cmb.ac.lk/ltrl/services/feconverter/ෙෙෙෙයම පදධත සඳො සංෙල සෙය (OS Support for Sinhala) - Confidential 070138R, 2009 Page 4 of 9Software Architecture Document   Date:  22. Oct. 20092.Architectural Representation view, and implementation view. These are views on an underlying Unified Modeling Language (UML) 3.Architectural Goals and Constraints 1. All functions of the extension must be available  independent of the Operating System (ie: that the extension should not use OS specific graphics adapters (GTK+/X11 for UNIX based OS 2. Architecture of the extension must adhere to the standard development guidelines of the Firefox 3. This system must be accurate and responsive enough for a normal user of Firefox to be solely 4. Public Standards and accepted protocols (including XML,XML schema and XUL) will be 5. All performance and loading requirements, as stipulated in the Vision Document and the Software developed.A description of the use-case view of the software architecture. The Use Case View is important input to scenarios and/or use cases that represent some significant, central functionality. It also describes the set of elements) or that stress or illustrate a specific, delicate point of the architecture.The use cases in this firefox extension are listed below.  A description of these use cases can be found later  Unicode typing on the goConvert Non-Unicode content to Unicode text1. User selects the text to be converted.extension's “SiyaBasSarana Typist” icon in status bar4. Text get converted to Sinhala/Tamil Unicode instantly in the text field itself.Siya Bas Sarana   Version:           <1.0>SiyaBasSaranaSAD1. User clicks on Tools>Addons>Siya Bas Sarana>Preferenceskey combination, Default suggested non Unicode font1.User selects the text to be converted to Unicodeextension's “Siya Bas Sarana Reader” icon in status barUnicode font is set.)The following diagram depicts the use cases in the system for the Actor 'User'.Siya Bas Sarana   Version:           <1.0>SiyaBasSaranaSAD5.1Overvieworganization in service packages and subsystems, and the organization of these subsystems into layers. architecture. Class diagrams may be included to illustrate the relationships between architecturally 5.2Architecturally Significant Design PackagesConversion Services, Settings management and Unicode Domain.the System. Boundary classes exist to support selecting languages,fonts and other options, viewing The Conversion Services Package contains control classes for major processing functionality within the management, and providing feedback via the UI.to Non-Unicode and vice versa in different font styles).Confidential 070138R, 2009 Page 7 of 9Software Architecture Document   Date:  22. Oct. 20096.Process View heavyweight processes (groupings of lightweight processes). Organize the section by groups of processes message passing, interrupts, and rendezvous.Extension.  Threads for application functions will be part of this process (application functions are listed in 6.1 ProcessesSiya Bas Sarana   Version:           <1.0>SiyaBasSaranaSADImplementation adheres to the standard Mozilla Firefox Extension ArchitectureThe chosen software architecture supports the key sizing and timing requirements, as stipulated in the 1. Response of UI elements should be quick and relevant when a key-stoke is pressed or on an icon-2. Text should be converted and displayed almost instantly after command is given.The selected architecture supports the sizing and timing requirements through the memory requirements are needed on the PC  running this extension.The software architecture supports the quality requirements, as stipulated in the Supplementary 1. An intuitive interface should be provided with standard UI elements and a side bar such that 2. Documentation must be provided to help the user with GUI and Sinhala phonetic text input.for Unicode text input and viewing inside the browser. null";
        //String s="Personal Assistant Fox (PA Fox)    Software Architecture Document   Date:  21/10/2009 Confidential University of Moratuwa, 2009 Page 2 of 9 Revision History 21/10/2009 1.0 Extension for Mozilla Firefox 3.5 Harshani Nawarathna      Software Architecture Document   Date:  21/10/2009 Confidential University of Moratuwa, 2009 Page 3 of 9 Table of Contents 1.1 Purpose 4 1.3 Definitions, Acronyms, and Abbreviations 4 1.5 Overview 4 3. Architectural Goals and Constraints 5 4.1 Use-Case Realizations 6 5.1 Overview 7 7. Deployment View 9 9. Quality 9 Software Architecture Document   Date:  21/10/2009 Confidential University of Moratuwa, 2009 Page 4 of 9 Software Architecture Document Software Architecture document provides compact, high-level details of the Mozilla Firefox extension, PA document also includes the purpose, scope, definitions, acronyms, abbreviations, references, and overview 1.1 Purpose architectural views to depict different aspects of the system. It is intended to capture and convey the  This Document only provides the higher-level view of the architecture of PA Fox and how it interacts with the system. PA Fox – Personal Assistant Fox   Check points: Software Architecture Document  Considerations)  RUP template This document contains higher level details of software architecture of PA Fox. The document use “4+1  Use case view  Process view  The software architecture model used in PA Fox is 4+1 view model architecture. It includes;  Development view- illustrates the system from the programmer’s perspective and the primary  Process view – deals with the dynamic aspects of the system and explains the system processes Personal Assistant Fox (PA Fox)   Version:           1.0    Scenario – Explains the system using scenarios or use cases     3. Architectural Goals and Constraints facilitate the user. not depend on the operating system. development tools. time constraint. Fit with the purpose and accurate functionality is the goal of the PA Fox architecture. 4. Use-Case View   Logical view Development Scenarios Software Architecture Document   Date:  21/10/2009 Confidential University of Moratuwa, 2009 Page 6 of 9      Time-s-up function: user input and it will take the time from the user input and count down the time till zero. When the time is  To-do function: and it will display the to-do list for the user. Personal Assistant Fox (PA Fox)   Version:           1.0   tabs and the user can easily close the unwanted tabs using it .         Time-s-up -Alert the user after a given time to indicate that he has been in the tab more than he expected to  To-do - To do list which includes which sites the user wants to access on a certain day or which tasks he  Tab Closer- List of currently running tabs which help user to close the unwanted tabs.    Time-s-up To-do Event handler Software Architecture Document   Date:  21/10/2009 Confidential University of Moratuwa, 2009 Page 8 of 9 6. Process View The processes of To-do function and Tab closer function are very simple. So the major attention goes to the process  Activity diagram of To-do function:      Personal Assistant Fox (PA Fox)   Version:           1.0     can run. No special hardware or software needed for the deployment.     OPERATING SYSTEMS  The size of the PA Fox is very small compared to the architecture of Mozilla Firefox.  9. Quality understand the system and enhance the functionality. with the computers clock and the time data will be accurate.  Time-s-up To-do Event handler ";
        //String s="matrixmanipulatorversion 1.0software architecture document   date:  19/10/2009date version authorconfidential c.s.n.j. fernando - 070125b, page 2 of 9software architecture document   date:  19/10/20091. introduction 41.2 scope 41.4 references 43. architectural goals and constraints 54.1 use-case realizations 75.1 overview 76. process view 88. implementation view 910. quality 92009matrixmanipulator   version:           1.0software architecture document 1.1 purposeof different architectural views to depict different aspects of the extension. it is intended to capture and 1.2 scopeapplication will be deployed. focus has been given to those use cases that are deemed technically the implementation view and the process view are to be decided, therefore they are not included in this 1.3 definitions, acronyms, and abbreviationsui – user interface1.4 references• rup documentsthis document uses the “4+1 view model”. it can be described as follows;involved with those uses cases and a brief description of each use case.• development view: this is the view that can be used by the programmers and the software • deployment view: this is the view that targets the system engineers. confidential c.s.n.j. fernando - 070125b, page 4 of 9software architecture document   date:  19/10/2009architectural goal is to come-up with an accurate, fast extension for ooo math/calc which will be able to architectural constraint is i have to adhere to the way of implementing a new extension for ooo and also 4. use-case view 2009matrixmanipulator   version:           1.0confidential c.s.n.j. fernando - 070125b, page 6 of 9software architecture document   date:  19/10/2009use cases actor description of use casesmatrix based end-user use in built functions to get the solutions that the user neededchanging the developer adding a new function, deleting an existing function, modifying testing developer testing the functionality of the extensionopenoffice.orgevaluation department doing final evaluation & giving comments5.1 overview5.2 architecturally significant design packages• since this is an ooo extension, underlined architecture of ooo must be used as the main platform.them.• matrixmanipulator uses a file system to keep a session based history up to some extent.2009matrixmanipulator   version:           1.06. process view confidential c.s.n.j. fernando - 070125b, page 8 of 9software architecture document   date:  19/10/20098. implementation view 9. size and performance course. • project will progress simultaneously with other academic work.10. quality • it should definitely extensible: scope of this extension is limited by me due to the time constraint, • application should be fast & user friendly2009null";
       //String s="matrixmanipulatorversion 1.0software architecture document   date:  19/10/2009date version authorconfidential c.s.n.j. fernando - 070125b, page 2 of 9software architecture document   date:  19/10/20091. introduction 41.2 scope 41.4 references 43. architectural goals and constraints 54.1 use-case realizations 75.1 overview 76. process view 88. implementation view 910. quality 92009matrixmanipulator   version:           1.0software architecture document 1.1 purposeof different architectural views to depict different aspects of the extension. it is intended to capture and 1.2 scopeapplication will be deployed. focus has been given to those use cases that are deemed technically the implementation view and the process view are to be decided, therefore they are not included in this 1.3 definitions, acronyms, and abbreviationsui – user interface1.4 references• rup documentsthis document uses the “4+1 view model”. it can be described as follows;involved with those uses cases and a brief description of each use case.• development view: this is the view that can be used by the programmers and the software • deployment view: this is the view that targets the system engineers. confidential c.s.n.j. fernando - 070125b, page 4 of 9software architecture document   date:  19/10/2009architectural goal is to come-up with an accurate, fast extension for ooo math/calc which will be able to architectural constraint is i have to adhere to the way of implementing a new extension for ooo and also 4. use-case view 2009matrixmanipulator   version:           1.0confidential c.s.n.j. fernando - 070125b, page 6 of 9software architecture document   date:  19/10/2009use cases actor description of use casesmatrix based end-user use in built functions to get the solutions that the user neededchanging the developer adding a new function, deleting an existing function, modifying testing developer testing the functionality of the extensionopenoffice.orgevaluation department doing final evaluation & giving comments5.1 overview5.2 architecturally significant design packages• since this is an ooo extension, underlined architecture of ooo must be used as the main platform.them.• matrixmanipulator uses a file system to keep a session based history up to some extent.2009matrixmanipulator   version:           1.06. process view confidential c.s.n.j. fernando - 070125b, page 8 of 9software architecture document   date:  19/10/20098. implementation view 9. size and performance course. • project will progress simultaneously with other academic work.10. quality • it should definitely extensible: scope of this extension is limited by me due to the time constraint, • application should be fast & user friendly2009null";
        String s="software architecture document version confidential cse, 2009 page 2 of 10  abiword version: <1.0>   date version description author          1.1 purpose 4 1.3 references 4 2. architectural representation 5 3. architectural goals and constraints 6 4. use-case view 8 5. logical view 9 6. deployment view 10 7. performance 10  software architecture document date: <22/10/2009> table of contents 1. introduction 4  software architecture document date: <22/10/2009>   this document describes evolving technical architecture of abiword cell align project is being extended from requirement specification document and technical stuffs regarding targeting on new developers, it can be identified appropriate classes. this document provides a high level comprehensive description of goals of architecture views and styles with its appropriate model architecture in an understandable way. this requirement and non-functional r equir e ment s play prominent  place.  refining   1.1 purpose                 number of different architectural views to depict different aspects of the system. it is                 made on the system.    this document mainly focuses architectural designs used while giving a high level     1.3 references   http://www.abisource.com/doxygen/   lecture notes. software architecture document date: <22/10/2009> 2. architectural representation  this document is going to use ‘4+1’ architecture model to represent core activities of the such as logical view, process view, development view, physical view and scenarios. the scenarios. each view is depicted in to detail in the following areas.    logical view physical view scenario     use case view: this section lists use cases or scenarios from the use-case model  logical view: this section describes the architecturally significant parts of the  (hardware) configurations on which the software is deployed and run   xap cross platform architecture   abiword version: <1.0>   3. architectural goals and constraints  layered abiword core      code used by applicatio        confidential cse, 2009 page 7 of 10  abiword version: <1.0>   separately defined for every platform. so, it makes extensive use of abstract virtual   common platform architecture     the users are firstly interacting with frame, then the layout control. piecetable changes are through the controller. since abiword team is following these class dependencies, i have to extend them in this  constrains: from the existing classes.  ahead with the existing process flow.  confidential cse, 2009 page 8 of 10   abiword version: <1.0>       create   select cell    user      click confidential cse, 2009 page 9 of 10   abiword version: <1.0>   5. logical view throughout all methods up to main. and also it is using layered type architecture under implementation is focusing on creating high level architecture while keeps the underlying               in the above diagram, the representation of class hierarchy is shown. this class hierarchy the hierarchy is reused in my project.  class inheritance tree formattable class  formattab    cell table     abiword version: <1.0>   classes that are going to extend format table class. two class clarifications are:  under the table class all format table existing components will be added exit and it will be extended the graphics class and appropriate classes as well.  6. deployment view   format menu :=> align=>1.verticaltop 3. verticalbottom            the abiword cell align will be provided the cell alignment facility which users can be  7. performance successfully in abiword and with the aid of this architecture document, it could be project. ";
        
        String preprocessed="this document provid high level comprehensive description ";



        System.out.println("full String is "+s);
        System.out.println("processed String is "+preprocessed);

        int index=0;
        int length=0;
        int startIndex=0;
        int endIndex=0;
        int count=0;
        ArrayList<Integer> indexArrayList=new ArrayList<Integer>();
        ArrayList<Integer> sortedArrayList=new ArrayList<Integer>();

        String[] preprocessedArray=preprocessed.split(" ");
        String firstWord=preprocessedArray[0].trim();
        startIndex=s.indexOf(firstWord);



        indexArrayList.add(startIndex);
        while(startIndex!=-1){
            startIndex=s.indexOf(firstWord,startIndex+firstWord.length());
            if(startIndex!=-1)
            indexArrayList.add(startIndex);
        }

        for(int indexes=0;indexes<indexArrayList.size();indexes++){
           System.out.println(indexArrayList.get(indexes));

        }















        ArrayList< StringDiffer> arrayDiffer=new ArrayList<StringDiffer>();
        DiffMatch test2= new DiffMatch();
    

        LinkedList<Diff> a=test2.diff_main(s,preprocessed);

        for (int i = 0; i < a.size(); i++){

        String token=""+ a.get(i);
        String processedToken= token.trim();
        System.out.println("token is "+ processedToken);
        String[] splitter=processedToken.split("~");

        System.out.println("state is "+splitter[0]);
        //System.out.println("String is "+splitter[1]);
        
        if(splitter.length==2){

            System.out.println("damn");
        StringDiffer differ=new StringDiffer(splitter[0],splitter[1]);
        arrayDiffer.add(differ);
            }
              }

        for(int i=0;i<arrayDiffer.size();i++){
            
            String state=arrayDiffer.get(i).getState();

            System.out.println("state is "+ state);
            String preprocessedString=arrayDiffer.get(i).getProcessedString();
           
            System.out.println("preprocessed is "+ preprocessedString);


            if(state.equalsIgnoreCase("EQUAL")){


                if(count==0){
                    //startIndex=s.indexOf(preprocessedString);
                }
                count++;

                if(i==arrayDiffer.size()-1){
                    
                    index=s.indexOf(preprocessedString);
                    endIndex=index +preprocessedString.length();
                    
                }
                 
            else{
                
                System.out.println("before start index " +preprocessedString );
                

                index=s.indexOf(preprocessedString);

                }
               
                
            }
            
            if(state.equalsIgnoreCase("DELETE")){
                
                
                
                
                if(i==arrayDiffer.size()-1){

                    index=s.indexOf(preprocessedString);
                    length=preprocessedString.length();                
                    endIndex=index ;
                
                }
                
 else{
                length=preprocessedString.length();
                index=index+length;
                }
               
                     }
            
        
        }

        System.out.println("end index is "+endIndex);

        System.out.println("arraylist size is "+indexArrayList.size());

       

        for(int j=0;j<indexArrayList.size();j++){

            int distance=endIndex-indexArrayList.get(j);
            System.out.println("distance of "+indexArrayList.get(j));
            if(distance > 0){
                System.out.println("Adding");
                sortedArrayList.add(indexArrayList.get(j));
            }


       }




         for(int j=0;j<sortedArrayList.size();j++){

           System.out.println("sorted Array list is"+sortedArrayList.get(j));

        }


TestMain tm=new TestMain();
        startIndex= tm.getMinimum(sortedArrayList);


        
        System.out.println("start index is "+startIndex);
        System.out.println("end index is "+endIndex);


    }






     public int getMinimum(ArrayList<Integer> array){

        int  mnm = array.get(0);
for (int i=0; i<array.size(); i++) {
if (array.get(i)>mnm) {
mnm = array.get(i);
}

}
return mnm;


     }


}
