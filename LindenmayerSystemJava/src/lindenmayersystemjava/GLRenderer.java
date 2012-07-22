package lindenmayersystemjava;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer implements GLEventListener {
    
    private float rTri = 0.0f;
    private float rQuad = 0.0f;
    
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        // Rotate The Triangle On The Y axis
        gl.glRotatef(rTri,0.0f,1.0f,0.0f);				
        
        // Drawing Using Triangles
        gl.glBegin(GL.GL_TRIANGLES);
        {
            //  Draw square based pyramid
            //  Front face
            gl.glColor3f(1.0f,0.0f,0.0f);			// Red
            gl.glVertex3f( 0.0f, 1.0f, 0.0f);			// Top Of Triangle (Front)
            gl.glColor3f(0.0f,1.0f,0.0f);			// Green
            gl.glVertex3f(-1.0f,-1.0f, 1.0f);			// Left Of Triangle (Front)
            gl.glColor3f(0.0f,0.0f,1.0f);			// Blue
            gl.glVertex3f( 1.0f,-1.0f, 1.0f);
            //  Right face
            gl.glColor3f(1.0f,0.0f,0.0f);			// Red
            gl.glVertex3f( 0.0f, 1.0f, 0.0f);			// Top Of Triangle (Right)
            gl.glColor3f(0.0f,0.0f,1.0f);			// Blue
            gl.glVertex3f( 1.0f,-1.0f, 1.0f);			// Left Of Triangle (Right)
            gl.glColor3f(0.0f,1.0f,0.0f);			// Green
            gl.glVertex3f( 1.0f,-1.0f, -1.0f);			// Right Of Triangle (Right)
            //  Back face
            gl.glColor3f(1.0f,0.0f,0.0f);			// Red
            gl.glVertex3f( 0.0f, 1.0f, 0.0f);			// Top Of Triangle (Back)
            gl.glColor3f(0.0f,1.0f,0.0f);			// Green
            gl.glVertex3f( 1.0f,-1.0f, -1.0f);			// Left Of Triangle (Back)
            gl.glColor3f(0.0f,0.0f,1.0f);			// Blue
            gl.glVertex3f(-1.0f,-1.0f, -1.0f);			// Right Of Triangle (Back)
            //  Left face
            gl.glColor3f(1.0f,0.0f,0.0f);			// Red
            gl.glVertex3f( 0.0f, 1.0f, 0.0f);			// Top Of Triangle (Left)
            gl.glColor3f(0.0f,0.0f,1.0f);			// Blue
            gl.glVertex3f(-1.0f,-1.0f,-1.0f);			// Left Of Triangle (Left)
            gl.glColor3f(0.0f,1.0f,0.0f);			// Green
            gl.glVertex3f(-1.0f,-1.0f, 1.0f);			// Right Of Triangle (Left)
            //  End of pyramid
        }
        gl.glEnd();

        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        
        // Move the "drawing cursor" to another position
        gl.glTranslatef(1.5f, 0.0f, -6.0f);
        
        // Rotate The Quad On The X axis
        gl.glRotatef(rQuad,1.0f,0.0f,0.0f);			
        
        // Draw A Quad
        gl.glBegin(GL.GL_QUADS);
        {
            //  Draw a cube
            //  Top face
            gl.glColor3f(0.0f,1.0f,0.0f);			// Set The Color To Green
            gl.glVertex3f( 1.0f, 1.0f,-1.0f);			// Top Right Of The Quad (Top)
            gl.glVertex3f(-1.0f, 1.0f,-1.0f);			// Top Left Of The Quad (Top)
            gl.glVertex3f(-1.0f, 1.0f, 1.0f);			// Bottom Left Of The Quad (Top)
            gl.glVertex3f( 1.0f, 1.0f, 1.0f);			// Bottom Right Of The Quad (Top)
            //  Bottom face
            gl.glColor3f(1.0f,0.5f,0.0f);			// Set The Color To Orange
            gl.glVertex3f( 1.0f,-1.0f, 1.0f);			// Top Right Of The Quad (Bottom)
            gl.glVertex3f(-1.0f,-1.0f, 1.0f);			// Top Left Of The Quad (Bottom)
            gl.glVertex3f(-1.0f,-1.0f,-1.0f);			// Bottom Left Of The Quad (Bottom)
            gl.glVertex3f( 1.0f,-1.0f,-1.0f);			// Bottom Right Of The Quad (Bottom)
            //  Front face
            gl.glColor3f(1.0f,0.0f,0.0f);			// Set The Color To Red
            gl.glVertex3f( 1.0f, 1.0f, 1.0f);			// Top Right Of The Quad (Front)
            gl.glVertex3f(-1.0f, 1.0f, 1.0f);			// Top Left Of The Quad (Front)
            gl.glVertex3f(-1.0f,-1.0f, 1.0f);			// Bottom Left Of The Quad (Front)
            gl.glVertex3f( 1.0f,-1.0f, 1.0f);			// Bottom Right Of The Quad (Front)
            //  Back face
            gl.glColor3f(1.0f,1.0f,0.0f);			// Set The Color To Yellow
            gl.glVertex3f( 1.0f,-1.0f,-1.0f);			// Bottom Left Of The Quad (Back)
            gl.glVertex3f(-1.0f,-1.0f,-1.0f);			// Bottom Right Of The Quad (Back)
            gl.glVertex3f(-1.0f, 1.0f,-1.0f);			// Top Right Of The Quad (Back)
            gl.glVertex3f( 1.0f, 1.0f,-1.0f);			// Top Left Of The Quad (Back)
            //  Left face
            gl.glColor3f(0.0f,0.0f,1.0f);			// Set The Color To Blue
            gl.glVertex3f(-1.0f, 1.0f, 1.0f);			// Top Right Of The Quad (Left)
            gl.glVertex3f(-1.0f, 1.0f,-1.0f);			// Top Left Of The Quad (Left)
            gl.glVertex3f(-1.0f,-1.0f,-1.0f);			// Bottom Left Of The Quad (Left)
            gl.glVertex3f(-1.0f,-1.0f, 1.0f);			// Bottom Right Of The Quad (Left)
            //  Right face
            gl.glColor3f(1.0f,0.0f,1.0f);			// Set The Color To Violet
            gl.glVertex3f( 1.0f, 1.0f,-1.0f);			// Top Right Of The Quad (Right)
            gl.glVertex3f( 1.0f, 1.0f, 1.0f);			// Top Left Of The Quad (Right)
            gl.glVertex3f( 1.0f,-1.0f, 1.0f);			// Bottom Left Of The Quad (Right)
            gl.glVertex3f( 1.0f,-1.0f,-1.0f);			// Bottom Right Of The Quad (Right)
            //  End of cube
        }
        gl.glEnd();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
        
        rTri += 1f;						// Increase The Rotation Variable For The Triangle ( NEW )
	rQuad -= 5f;
    }

    public void displayChanged(GLAutoDrawable drawable, 
            boolean modeChanged, 
            boolean deviceChanged) 
    {
        
    }
}

