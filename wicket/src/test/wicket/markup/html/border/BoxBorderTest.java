/*
 * $Id$
 * $Revision$ $Date$
 * 
 * ======================================================================== 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may 
 * not use this file except in compliance with the License. You may obtain 
 * a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.markup.html.border;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import wicket.markup.html.list.DiffUtil;
import wicket.protocol.http.MockWebApplication;

/**
 * Test the component: WicketComponentTree
 * 
 * @author Juergen Donnerstag
 */
public class BoxBorderTest extends TestCase
{
	private static Log log = LogFactory.getLog(BoxBorderTest.class);

	private MockWebApplication application;

	/**
	 * Create the test.
	 * 
	 * @param name
	 *            The test name
	 */
	public BoxBorderTest(String name)
	{
		super(name);
	}

	/**
	 * @throws Exception
	 */
	protected void setUp() throws Exception
	{
		super.setUp();
		application = new MockWebApplication(null);
		application.getPages().setHomePage(BoxBorderTestPage.class);
	}

	/**
	 * Test a simply page containing the debug component
	 * @throws Exception
	 */
	public void test1() throws Exception
	{
		// Do the processing
	    application.setupRequestAndResponse();
		application.processRequestCycle();

		// Validate the document
		String document = application.getServletResponse().getDocument();
		log.info(document);
		assertTrue(validatePage(document, "BoxBorderTestPage_ExpectedResult.html"));
	}
	
	private boolean validatePage(final String document, final String file) throws IOException
	{
		return DiffUtil.validatePage(document, this.getClass(), file);
	}
}