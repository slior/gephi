/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */
package org.gephi.ui.filters.plugin.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.gephi.filters.plugin.graph.EgoBuilder.EgoFilter;

/**
 *
 * @author Mathieu Bastian
 */
public class EgoPanel extends javax.swing.JPanel {

    private EgoFilter egoFilter;

    /** Creates new form EgoPanel */
    public EgoPanel() {
        initComponents();

        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                egoFilter.getProperties()[0].setValue(nodeIdTextField.getText());
            }
        });

        depthComboBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                int depth = -1;
                int index = depthComboBox.getSelectedIndex();
                if (index == depthComboBox.getModel().getSize() - 1) {
                    depth = Integer.MAX_VALUE;
                } else {
                    depth = index + 1;
                }
                if (!egoFilter.getDepth().equals(depth)) {
                    egoFilter.getProperties()[1].setValue(depth);
                }
            }
        });

        withSelfCheckbox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (!egoFilter.isSelf() == withSelfCheckbox.isSelected()) {
                    egoFilter.getProperties()[2].setValue(withSelfCheckbox.isSelected());
                }
            }
        });
    }

    public void setup(EgoFilter egoFilter) {
        this.egoFilter = egoFilter;
        nodeIdTextField.setText(egoFilter.getPattern());

        int depth = egoFilter.getDepth();
        if (depth == Integer.MAX_VALUE) {
            depthComboBox.setSelectedIndex(depthComboBox.getModel().getSize() - 1);
        } else {
            depthComboBox.setSelectedIndex(depth - 1);
        }

        withSelfCheckbox.setSelected(egoFilter.isSelf());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNodeId = new javax.swing.JLabel();
        nodeIdTextField = new javax.swing.JTextField();
        labelDepth = new javax.swing.JLabel();
        depthComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        withSelfCheckbox = new javax.swing.JCheckBox();

        labelNodeId.setText(org.openide.util.NbBundle.getMessage(EgoPanel.class, "EgoPanel.labelNodeId.text")); // NOI18N

        nodeIdTextField.setText(org.openide.util.NbBundle.getMessage(EgoPanel.class, "EgoPanel.nodeIdTextField.text")); // NOI18N
        nodeIdTextField.setToolTipText(org.openide.util.NbBundle.getMessage(EgoPanel.class, "EgoPanel.nodeIdTextField.toolTipText")); // NOI18N

        labelDepth.setText(org.openide.util.NbBundle.getMessage(EgoPanel.class, "EgoPanel.labelDepth.text")); // NOI18N

        depthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "Max" }));

        okButton.setText(org.openide.util.NbBundle.getMessage(EgoPanel.class, "EgoPanel.okButton.text")); // NOI18N
        okButton.setMargin(new java.awt.Insets(2, 7, 2, 7));

        withSelfCheckbox.setText(org.openide.util.NbBundle.getMessage(EgoPanel.class, "EgoPanel.withSelfCheckbox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNodeId)
                    .addComponent(labelDepth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(withSelfCheckbox)
                    .addComponent(depthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nodeIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNodeId)
                    .addComponent(nodeIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDepth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(withSelfCheckbox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox depthComboBox;
    private javax.swing.JLabel labelDepth;
    private javax.swing.JLabel labelNodeId;
    private javax.swing.JTextField nodeIdTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox withSelfCheckbox;
    // End of variables declaration//GEN-END:variables
}