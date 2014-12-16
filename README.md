<h1 id="eksplorasi-broadleaf-commerce">Eksplorasi Broadleaf Commerce</h1>

<blockquote>
  <p>Disusun Oleh:</p>
  
  <ol>
  <li>Dimas Angga S / 13510046</li>
  <li>Inov Yomanovian / 13510067</li>
  <li>Pande Made P P / 13510082</li>
  <li>Yanuar Aristya E P / 13511039</li>
  <li>Arini Sirait / 13511082</li>
  </ol>
</blockquote>

<hr>



<h2 id="table-of-contents">Table of Contents</h2>

<p><div class="toc"><div class="toc">
<ul>
<li><a href="#eksplorasi-broadleaf-commerce">Eksplorasi Broadleaf Commerce</a><ul>
<li><a href="#table-of-contents">Table of Contents</a></li>
<li><a href="#broadleaf-commerce">Broadleaf Commerce</a></li>
<li><a href="#eksplorasi-broadleaf-commerce-1">Eksplorasi Broadleaf Commerce</a><ul>
<li><a href="#instalasi-broadleaf">Instalasi Broadleaf</a><ul>
<li><a href="#prerequisites">Prerequisites</a></li>
<li><a href="#ide-setup">IDE Setup</a></li>
</ul>
</li>
<li><a href="#eksplorasi-fitur-broadleaf-commerce">Eksplorasi Fitur Broadleaf Commerce</a></li>
</ul>
</li>
</ul>
</li>
</ul>
</div>
</div>
</p>

<hr>

<p><a href="http://www.broadleafcommerce.com/"><img src="http://www.broadleafcommerce.com/img/broadleaf_logo_white.png" alt="" title=""></a></p>



<h2 id="broadleaf-commerce">Broadleaf Commerce</h2>

<p>Broadleaf Commerce merupakan platform e-commerce open-source. Broadleaf commerce dikembangkan dengan bahasa <strong>Java</strong> diatas <strong>Spring framework</strong>. Broadleaf banyak menggunakan teknologi open-source seperti <strong>Hibernate</strong> untuk ORM, <strong>Thymeleaf</strong> untuk templating, <strong>Jax-RS</strong> untuk REST services, dan teknologi open-source lainnya.</p>

<p><a href="http://www.broadleafcommerce.com/technology-stack">Broadleaf Commerce Technology Stack</a></p>



<h2 id="eksplorasi-broadleaf-commerce-1">Eksplorasi Broadleaf Commerce</h2>



<h3 id="instalasi-broadleaf">Instalasi Broadleaf</h3>



<h4 id="prerequisites">Prerequisites</h4>

<ol>
<li>Java 7 Development Kit (JDK)</li>
<li>Maven</li>
</ol>



<h4 id="ide-setup">IDE Setup</h4>

<p>Pengembangan e-commerce broadleaf dilakukan dengan Eclipse.</p>

<p><a href="Broadleaf%20Commerce%20memiliki%20prepackaged%20Eclipse%20project%20untuk%20membantu%20kita%20memulai%20menggunakan%20broadleaf.">Download Eclipse IDE for Java EE Developers</a> <br>
Setelah mendownload Eclipse IDE, install Maven Integration dari <code>Help-&gt;Marketplace-&gt; Search "Maven Integration"</code></p>

<p>Broadleaf Commerce memiliki <em>prepackaged Eclipse project</em> untuk memudahkan developer memulai mengembangkan di platform broadleaf.</p>

<p><a href="http://www.broadleafcommerce.org/workspace-download?workspaceVersion=DemoSite-3.1.10-GA-eclipse-workspace.zip&amp;docsVersion=current">Download Broadleaf Eclipse Workspace</a> <br>
Terdapat tiga folder dari workspace yang didownload, yaitu <strong>core</strong>, <strong>admin</strong>, dan <strong>site</strong>.</p>

<p>Core merupakan komponen yang digunakan di kedua project admin dan site.</p>

<p>Admin merupakan project yang secara umum berisi komponen CMS (Content Management System) dan CRM (Customer Relationship Management), </p>

<p>Site merupakan project yang berisi platform e-commerce. Site merupakan apa yang akan diakses oleh customer disaat websitenya sudah live.</p>

<p><strong>Getting Started</strong></p>

<ol>
<li>Import workspace yang sudah di download kedalam Eclipse IDE dengan <code>Import Maven Project</code></li>
<li>Add Buildfiles admin/build.xml dan site/build.xml`</li>
<li>Install semua maven dependency yang dibutuhkan.</li>
<li>Jalankan jetty-demo pada window Ant.</li>
<li>Coba bandingkan admin dan site.</li>
</ol>

<p>Untuk informasi lebih mengenai instalasi dan memulai menggunakan Broadleaf Commerce, dapat mengakses pranala berikut <br>
<a href="http://www.broadleafcommerce.com/docs/core/current/getting-started">Getting started with Broadleaf Commerce</a></p>

<h3 id="eksplorasi-fitur-broadleaf-commerce">Eksplorasi Fitur Broadleaf Commerce</h3>

<p>Setelah berhasil melakukan instalasi broadleaf commerce, yang kami lakukan selanjutnya adalah melakukan eksplorasi tentang bagaimana broadleaf commerce melakukan tugasnya.</p>

<p>Implementasi yang kami lakukan terkait broadleaf adalah meng-extend service payment gateway, yaitu menjadi NullPaymentGateway.</p>