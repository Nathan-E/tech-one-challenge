<h2>TECH-ONE-CHALLENGES REPORT</h2>
Challenge 1:
A rest API to talk to another open api and fetch the following report:
1.	The list of most active records according the set threshold.
2.	The author with highest comment count.
3.	The list of author sorted by when the record was created according to threshold.
<br />
The following are tool used in creating the application:
1.	OS: window 7
2.	Framework: SpringBoot  2.3
3.	Maven Project
4.	Packaging: Jar
5.	Dependencies: web and reactive webflux
6.	Port: 8080 //default port
<br />
Implantation:
I use webclient builder from web reactive dependencies to consume the open Api asynchronously.
Function 1: getUsernames(int threshold) : I add page number to make it dynamic.
URL: users/active-authors-submission-count/{page}/{threshold}
Example: http://localhost:8080/users/active-authors-submission-count/1/23
Function 2: getUsernamesWithHighestCommentCount.
URL:  /users/highest-comment-count/{page}
Example: http://localhost:8080/users/highest-comment-count/1
Function 3: getUsernameSortedByRecordDate(int threshold)
URL: /users/username-sorted-by-recorddate/{page}/{threshold} 
Example: http://localhost:8080/users/username-sorted-by-recorddate/1/5

<br />

Challenge 2:  A function that will return the maximum number of socks Anna can bring on her trips.
HasMap data structure was used to solve it. I try to add comment to make the code a bit clearer the idea used is simple. First I search the clean pile and compare to get number of already clean pairs of socks and return it if no of washes is zero and did the same with dirty piles of socks too.
<br />
Arrangement of folders: 
I created a folder named Tech-one-challenges and inside consist SpringBoot(Api app) and Class file of AnasockDrawer.java.
