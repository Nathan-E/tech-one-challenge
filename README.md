<h2>TECH-ONE-CHALLENGES REPORT</h2>
<p>
Challenge 1:
 A rest API to talk to another open api and fetch the following report:
<ul>
 <li>The list of most active records according the set threshold. </li>
 <li>The author with highest comment count.</li>
 <li>The list of author sorted by when the record was created according to threshold</li>
</ul>


</p>
<p>
The following are tool used in creating the application:
 <ul>
  <li>OS: window 7 </li>
  <li> Framework: SpringBoot  2.3 </li>
  <li> Maven Project </li>
  <li>Packaging: Jar </li>
  <li>Dependencies: web and reactive webflux </li>
  <li>Port: 8080 //default port </li>
  </ul>
</p>
<p>
Implantation:
 <ul>
I use webclient builder from web reactive dependencies to consume the open Api asynchronously.
<li>Function 1: getUsernames(int threshold) : I add page number to make it dynamic.
URL: users/active-authors-submission-count/{page}/{threshold}
Example: http://localhost:8080/users/active-authors-submission-count/1/23 <li>
<li>Function 2: getUsernamesWithHighestCommentCount.
URL:  /users/highest-comment-count/{page}
 Example: http://localhost:8080/users/highest-comment-count/1 </li>
<li>Function 3: getUsernameSortedByRecordDate(int threshold)
URL: /users/username-sorted-by-recorddate/{page}/{threshold} 
 Example: http://localhost:8080/users/username-sorted-by-recorddate/1/5 </li>
</ul>
</p>
<p>
Challenge 2:  A function that will return the maximum number of socks Anna can bring on her trips.
HasMap data structure was used to solve it. I try to add comment to make the code a bit clearer the idea used is simple. First I search the clean pile and compare to get number of already clean pairs of socks and return it if no of washes is zero and did the same with dirty piles of socks too.
</p>
<p>
Arrangement of folders: 
I created a folder named Tech-one-challenges and inside consist SpringBoot(Api app) and Class file of AnasockDrawer.java.
 </p>
