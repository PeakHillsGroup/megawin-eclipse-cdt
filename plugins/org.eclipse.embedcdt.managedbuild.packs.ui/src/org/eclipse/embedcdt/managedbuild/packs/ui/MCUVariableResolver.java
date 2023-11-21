package org.eclipse.embedcdt.managedbuild.packs.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.variableresolvers.PathVariableResolver;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.core.variables.IDynamicVariable;
import org.eclipse.core.variables.IDynamicVariableResolver;
import org.eclipse.embedcdt.internal.managedbuild.packs.ui.Activator;

public class MCUVariableResolver extends PathVariableResolver implements IDynamicVariableResolver {

	public static final String MEGA_MCU_NAME = "mega_mcu_name";
	public static final String EMPTY_STRING = "";

	@Override
	public String getValue(String variable, IResource resource) {
		return "789";
	}

	@Override
	public String resolveValue(IDynamicVariable variable, String argument) throws CoreException {

		String varName = variable.getName();

		if (varName.equals(MEGA_MCU_NAME)) {
			IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
			return preferences.get(MEGA_MCU_NAME, EMPTY_STRING);
		}

		return EMPTY_STRING;
	}

}
