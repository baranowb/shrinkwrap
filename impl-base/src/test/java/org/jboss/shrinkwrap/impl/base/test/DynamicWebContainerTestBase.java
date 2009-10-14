/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.impl.base.test;

import junit.framework.Assert;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Path;
import org.jboss.shrinkwrap.api.container.WebContainer;
import org.jboss.shrinkwrap.impl.base.path.BasicPath;
import org.junit.Test;

/**
 * DynamicWebContainerTestBase
 *
 * @author <a href="mailto:aslak@conduct.no">Aslak Knutsen</a>
 * @version $Revision: $
 * @param <T>
 */
public abstract class DynamicWebContainerTestBase<T extends Archive<T>> extends DynamicContainerTestBase<T>
{
   public abstract Path getWebPath();
   public abstract WebContainer<T> getWebContainer();
   
   //-------------------------------------------------------------------------------------||
   // Test Implementations - WebContainer ------------------------------------------------||
   //-------------------------------------------------------------------------------------||

   @Test
   @ArchiveType(WebContainer.class)
   public void testSetWebXMLResource() throws Exception {
      getWebContainer().setWebXML(NAME_TEST_PROPERTIES);
      
      Path testPath = new BasicPath(getWebPath(), "web.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testSetWebXMLFile() throws Exception {
      getWebContainer().setWebXML(getFileForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "web.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testSetWebXMLURL() throws Exception {
      getWebContainer().setWebXML(getURLForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "web.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }
   
   @Test
   @ArchiveType(WebContainer.class)
   public void testSetWebXMLAsset() throws Exception {
      getWebContainer().setWebXML(getAssetForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "web.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourceResource() throws Exception {
      getWebContainer().addWebResource(NAME_TEST_PROPERTIES);
      
      Path testPath = new BasicPath(getWebPath(), "Test.properties");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourceFile() throws Exception {
      getWebContainer().addWebResource(getFileForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "Test.properties");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }
   
   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourceURL() throws Exception {
      Path targetPath = new BasicPath("Test.properties");
      getWebContainer().addWebResource(targetPath, getURLForClassResource(NAME_TEST_PROPERTIES));
      Path testPath = new BasicPath(getWebPath(), targetPath);
      Assert.assertTrue("Archive should contain " + testPath, getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourceStringTargetResource() throws Exception {
      getWebContainer().addWebResource("Test.txt", NAME_TEST_PROPERTIES);
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourceStringTargetFile() throws Exception {
      getWebContainer().addWebResource("Test.txt", getFileForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourceStringTargetURL() throws Exception {
      getWebContainer().addWebResource("Test.txt", getURLForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourceStringTargetAsset() throws Exception {
      getWebContainer().addWebResource("Test.txt", getAssetForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourcePathTargetResource() throws Exception {
      getWebContainer().addWebResource(new BasicPath("Test.txt"), NAME_TEST_PROPERTIES);
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourcePathTargetFile() throws Exception {
      getWebContainer().addWebResource(new BasicPath("Test.txt"), getFileForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourcePathTargetURL() throws Exception {
      getWebContainer().addWebResource(new BasicPath("Test.txt"), getURLForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(WebContainer.class)
   public void testAddWebResourcePathTargetAsset() throws Exception {
      getWebContainer().addWebResource(new BasicPath("Test.txt"), getAssetForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getWebPath(), "Test.txt");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }
}
