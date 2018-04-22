# oapserver

#### Legal Disclaimer
*This repository is a software product and is not official communication 
of the National Oceanic and Atmospheric Administration (NOAA), or the 
United States Department of Commerce (DOC).  All NOAA GitHub project 
code is provided on an 'as is' basis and the user assumes responsibility 
for its use.  Any claims against the DOC or DOC bureaus stemming from 
the use of this GitHub project will be governed by all applicable Federal 
law.  Any reference to specific commercial products, processes, or services 
by service mark, trademark, manufacturer, or otherwise, does not constitute 
or imply their endorsement, recommendation, or favoring by the DOC. 
The DOC seal and logo, or the seal and logo of a DOC bureau, shall not 
be used in any manner to imply endorsement of any commercial product 
or activity by the DOC or the United States Government.*

This is the server-side component of the [OAP Metadata Editor](https://github.com/NOAA-PMEL/OAPMetadataEditor).

This server will:

1. Take an XML file from the client and return a JSON representative that can be used to populate the client for editing.
2. Take the JSON file, save it as Grails Domain objects and return an XML document to be saved on the local computer.
     * If the submited JSON has an expocode that matches an existing document, if the new document is valid the old one is replaced.
     * If the expocode does not eist and the document is valid the document is saved.
