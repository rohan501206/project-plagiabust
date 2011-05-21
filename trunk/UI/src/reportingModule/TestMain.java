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

        //String s= "mayuraVersion 1.0Software Architecture Document   Date:  26/12/2009Revision History5th October 2009 1 Project Feasibility Document Suresh9th October 2009 1 Project Schedule Suresh16th October 2009 1 System Requirement Specification Suresh29th October 2009 1 States Assessment Document 1 Suresh12th  November 2009 1 States Assessment Document 3 Suresh23rd November 2009 1 States Assessment Document 5 Suresh8th December 2009 1 States Assessment Document 7 SureshConfidential University Of Moratuwa, 2009 Page 2 of 12Software Architecture Document   Date:  26/12/2009Table of Contents1.1 Purpose 41.3 Definitions, Acronyms, and Abbreviations 41.5 Overview 43. Architectural Goals and Constraints 64.1 Use-Case Realizations 106. Process View and Deployment View. 118. Quality 12Confidential University Of Moratuwa, 2009 Page 3 of 12Software Architecture Document   Date:  26/12/2009Software Architecture Document “Ceylon Radio” is an extension for the web browser Mozilla Firefox which is developed as the progress of the project of the week which started from 7th December 2009 to 13th December 1.1 Purposeof different architectural views to depict different aspects of the system. It is intended to capture 1.2 Scopedocument only highlights the weekly progress of the project.• CSE: Computer Science and Engineering.• GUI: Graphical User Interface• SAD: Software Architectural Document.• WMP : Windows Media Player.• Gecko : Mozilla Browser Engine.• http://lms.uom.lk/moodle192/course/view.php?id=109  1.5 Overview• Section 3: describes the architectural constraints of the system• Section 5: describes the functionalities.• Section 7: describes how the system is deployed.• Section 9: describes any aspects related to the quality of service (QoS) attributes Confidential University Of Moratuwa, 2009 Page 4 of 12Software Architecture Document   Date:  26/12/20092. Architectural Representation architecture the add-on mayura. Describes nonfunctional requirements of the system. method is used). Describes functional requirements of the system.development environment. reflects its distributed aspect.significant, central functionality of the system. Describes the actors and use cases for the system, discrete flows and constraints in more detail. mayura   Version:           1.0mayura_SADGoal : online  radio streams. Basically users should be able to select channels, adjust the volume, basic requirements mentioned above.• Time: project should meet the given dead lines.architecture.◦ GUI implementation – XUL ◦ Functionality s – Java Script• Documentation : documentation should be done according to RUP standards.This project mainly involve with 3 actors. 1. End users:who are addicted to Sri Lankan radio channels.  They basically download, install and run 2. Project Mentors:regulations,monitors the progress of the project and instruct, provide necessary facilities 3. Designer:Confidential University Of Moratuwa, 2009 Page 6 of 12Software Architecture Document   Date:  26/12/2009Confidential University Of Moratuwa, 2009 Page 7 of 12Software Architecture Document   Date:  26/12/2009Confidential University Of Moratuwa, 2009 Page 8 of 12Software Architecture Document   Date:  26/12/2009Confidential University Of Moratuwa, 2009 Page 9 of 12Software Architecture Document   Date:  26/12/20094.1 Use-Case Realizations• Scripts associated with the GUI send control commands to the embedded WMP.• Embedded WMP interacts with the Gecko Engine.5. Logical View Tool bar EmbeddedWMP GeckoEngine OSJava Script Hardware Content  Locale Skin  Install.rdf Chrome.mainifest content.rdf File mayura.js File mayura.dtd File mayura.css FileSoftware Architecture Document   Date:  26/12/20096. Process View and Deployment View.gecko engine are run as threads inside the main process. Confidential University Of Moratuwa, 2009 Page 11 of 12Software Architecture Document   Date:  26/12/20098. Qualityextension which is lightweight and portable. This extensions can be installed either by download • Firefox's add-on manager manages and monitors behaviors of add-on s installed to the browser. handles security issues . But any how firefox do not guarantee integrity of each and every add-on • Firefox add-on architecture is a set of independent interactive modules (or files). Some modules languages (dtd files) and some handles installation and dynamic linking (install.mainifest file and  null";
      // String s="  software architecture document version 1.0 type well   version:           1.0  confidential <company name>, 2009 page 2 of 9 revision history 20/10/09 1.0  melaka gunasekara      software architecture document   date:  29/10/09   1. introduction 4 1.2 scope 4 1.4 references 4 3. architectural goals and constraints 5 4.1 use-case realizations 6 5.1 architecturally significant design packages 7 7. deployment view 8 9. size and performance 9 type well   version:           1.0  confidential <company name>, 2009 page 4 of 9 software architecture document  this document describes the major architectural design of the extension type well. it contains ten major and abbreviations. in the second sections architectural representation used for this document is described. system. under use case realization a significant use-case of the system is described. then the logical view, performance and the quality of the system are discussed briefly.  this document provides a comprehensive architectural overview of the system, using a number of different significant architectural decisions which have been made on the system. this software architecture document describes the architecture used in the project type well using 1.3 definitions, acronyms, and abbreviations • uno- universal network objects  1.4 references  • type well  system requirement specification document version 1.0 the architecture of the project type well is represented using rup guidelines.  4+1 model is used to logical view-the logical view is concerned with the functionality that the system provides to end-users development view-the development view illustrates a system from a programmer’s perspective and is covers a lot of details of the system development view are not described in this document. the system should be deployed.  processes and how they communicate, and focus on the runtime behavior of the system.   software architecture document   date:  29/10/09         instead of scenarios to describe the architecture of the system use cases are used in this document. 3. architectural goals and constraints  development for openoffice.org and i selected java for this extension. because of that for designing • when this extension is plugged to ooo writer it should work properly with other extensions installed format for the extension repository i’m going to use .xot for my extension which solves many system • user profiling is available in this extension. but the system does not have many security features since enter to their profiles.  for computer science and engineering. because of this reason project should be developed according period of time which is 8 weeks.         view process view deployment view  type well   version:           1.0  confidential <company name>, 2009 page 6 of 9 use-case  4.1 use-case realizations this is a use-case which should be given more attention in implementing since this is where the user  auto measure is the key functionality of this extension which differs other typing tutors form type well.    software architecture document   date:  29/10/09          • auto measure- for the users to get an idea about their current ability of typing and to measure the writer and when using training tools. this is implemented in order to provide the user with a • training arena- a mechanism which helps the users to improve their typing ability. touch typing who are new to typing and also who are bit familiar typing. each user’s improvement should be • user profiling -user profiling should be used to keep track of the improvements of each user. only • user help-instructions to the users to how to use this product in an efficient way and how can they   training arena- this is the component of the system which gives the functionality of training for the user.    auto training arena help        type well user training  software architecture document   date:  29/10/09   there are three major processes of this extension. the y are auto measure, view help and training arena. view. but training arena is a complex process and it is described as follows.                  type well is an extension for openoffice.org writer. then the extension is plugged to           type well measure openoffice.org type well   version:           1.0  confidential <company name>, 2009 page 9 of 9 1. microsoft windows 3. solaris: x86 platform edition 5. mac os x 8. implementation view  concerned with software management. further studies testing and selections of the technology should be  • user capacity-any user of ooo writer can use type well to measure his/her typing ability. only • memory-this product should not consume too much memory (< 500k)  • this is an extension for ooo writer which is free and open source software. there is a large modularity should be preserved. using proper naming conventions, well commented codes and • since this is an extension, it should not affect the overall system performance. using low memory null";
       //String s= " software architecture document version 1.0 type well   version:           1.0  confidential <company name>, 2009 page 2 of 9 revision history 20/10/09 1.0  melaka gunasekara      software architecture document   date:  29/10/09   1. introduction 4 1.2 scope 4 1.4 references 4 3. architectural goals and constraints 5 4.1 use-case realizations 6 5.1 architecturally significant design packages 7 7. deployment view 8 9. size and performance 9 type well   version:           1.0  confidential <company name>, 2009 page 4 of 9 software architecture document  this document describes the major architectural design of the extension type well. it contains ten major and abbreviations. in the second sections architectural representation used for this document is described. system. under use case realization a significant use-case of the system is described. then the logical view, performance and the quality of the system are discussed briefly.  this document provides a comprehensive architectural overview of the system, using a number of different significant architectural decisions which have been made on the system. this software architecture document describes the architecture used in the project type well using 1.3 definitions, acronyms, and abbreviations • uno- universal network objects  1.4 references  • type well  system requirement specification document version 1.0 the architecture of the project type well is represented using rup guidelines.  4+1 model is used to logical view-the logical view is concerned with the functionality that the system provides to end-users development view-the development view illustrates a system from a programmer’s perspective and is covers a lot of details of the system development view are not described in this document. the system should be deployed.  processes and how they communicate, and focus on the runtime behavior of the system.   software architecture document   date:  29/10/09         instead of scenarios to describe the architecture of the system use cases are used in this document. 3. architectural goals and constraints  development for openoffice.org and i selected java for this extension. because of that for designing • when this extension is plugged to ooo writer it should work properly with other extensions installed format for the extension repository i’m going to use .xot for my extension which solves many system • user profiling is available in this extension. but the system does not have many security features since enter to their profiles.  for computer science and engineering. because of this reason project should be developed according period of time which is 8 weeks.         view process view deployment view  type well   version:           1.0  confidential <company name>, 2009 page 6 of 9 use-case  4.1 use-case realizations this is a use-case which should be given more attention in implementing since this is where the user  auto measure is the key functionality of this extension which differs other typing tutors form type well.    software architecture document   date:  29/10/09          • auto measure- for the users to get an idea about their current ability of typing and to measure the writer and when using training tools. this is implemented in order to provide the user with a • training arena- a mechanism which helps the users to improve their typing ability. touch typing who are new to typing and also who are bit familiar typing. each user’s improvement should be • user profiling -user profiling should be used to keep track of the improvements of each user. only • user help-instructions to the users to how to use this product in an efficient way and how can they   training arena- this is the component of the system which gives the functionality of training for the user.    auto training arena help        type well user training  software architecture document   date:  29/10/09   there are three major processes of this extension. the y are auto measure, view help and training arena. view. but training arena is a complex process and it is described as follows.                  type well is an extension for openoffice.org writer. then the extension is plugged to           type well measure openoffice.org type well   version:           1.0  confidential <company name>, 2009 page 9 of 9 1. microsoft windows 3. solaris: x86 platform edition 5. mac os x 8. implementation view  concerned with software management. further studies testing and selections of the technology should be  • user capacity-any user of ooo writer can use type well to measure his/her typing ability. only • memory-this product should not consume too much memory (< 500k)  • this is an extension for ooo writer which is free and open source software. there is a large modularity should be preserved. using proper naming conventions, well commented codes and • since this is an extension, it should not affect the overall system performance. using low memory null";
      String s= "software architecture is software architecture";
        String preprocessed="softwar architectur";
        System.out.println("full String is "+s);
        System.out.println("processed String is "+preprocessed);

        int index=0;
        int length=0;
        int startIndex=0;
        int endIndex=0;
        int count=0;

        ArrayList< StringDiffer> arrayDiffer=new ArrayList<StringDiffer>();
        DiffMatch test2= new DiffMatch();
    

        LinkedList<Diff> a=test2.diff_main(s,preprocessed);

        for (int i = 0; i < a.size(); i++){

        String token=""+ a.get(i);
        String processedToken= token.trim();
        System.out.println("token is "+ processedToken);
        String[] splitter=processedToken.split("~");

        

        StringDiffer differ=new StringDiffer(splitter[0],splitter[1]);
        arrayDiffer.add(differ);

              }

        for(int i=0;i<arrayDiffer.size();i++){
            
            String state=arrayDiffer.get(i).getState();

            System.out.println("state is "+ state);
            String preprocessedString=arrayDiffer.get(i).getProcessedString();
           
            System.out.println("preprocessed is "+ preprocessedString);


            if(state.equalsIgnoreCase("EQUAL")){


                if(count==0){
                    startIndex=s.indexOf(preprocessedString);
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
        
        System.out.println("start index is "+startIndex);
        System.out.println("end index is "+endIndex);


    }


}
