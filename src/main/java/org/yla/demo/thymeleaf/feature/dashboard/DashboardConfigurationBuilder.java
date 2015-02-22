package org.yla.demo.thymeleaf.feature.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.yla.demo.thymeleaf.feature.gallery.Gallery;

public class DashboardConfigurationBuilder {

	public DashboardConfiguration build(Gallery gallery) {
		DashboardConfiguration config = new DashboardConfiguration();
		List<DashboardLine> lines = new ArrayList<>();
		config.setLines(lines);

		int imageIndex = 0;
		int nbImages = gallery.getImagesPaths().size();
		//int nbColumns = gallery.getImagesPerLines();
		DashboardLine line = new DashboardLine();
		lines.add(line);
		for (int j = 0; imageIndex < nbImages; j++) {
			DashboardLineContainer container = new DashboardLineContainer();
			DashboardWidget widget = new DashboardWidget();
			widget.setFragmentUrl("/widget/4");
			widget.getParams().put("imageSrc", gallery.getImagesPaths().get(imageIndex++));
			container.setCssClass("col-xs-4 col-lg-1");
			container.getWidgets().add(widget);
			line.getContainers().add(container);
		}
			
		return config;
	}
	
	public DashboardConfiguration buildOLD(Gallery gallery) {
		DashboardConfiguration config = new DashboardConfiguration();
		List<DashboardLine> lines = new ArrayList<>();
		config.setLines(lines);
		
		// 5
		// 3 col
		
		// 5 / 3 = 1
		
		int imageIndex = 0;
		int nbImages = gallery.getImagesPaths().size();
		int nbColumns = gallery.getImagesPerLines();
		int nbLines = nbImages / nbColumns;
		if (gallery.getImagesPaths().size() % nbColumns != 0) {
			nbLines++;
		}
		for (int i = 0; i < nbLines; i++) {
			DashboardLine line = new DashboardLine();
			lines.add(line);
			for (int j = 0; j < nbColumns && imageIndex < nbImages; j++) {
				DashboardLineContainer container = new DashboardLineContainer();
				DashboardWidget widget = new DashboardWidget();
				widget.setFragmentUrl("/widget/4");
				widget.getParams().put("imageSrc", gallery.getImagesPaths().get(imageIndex++));
				container.setCssClass("col-xs-3 col-lg-1");
				container.getWidgets().add(widget);
				line.getContainers().add(container);
			}
			
		}
		return config;
	}
	
}
