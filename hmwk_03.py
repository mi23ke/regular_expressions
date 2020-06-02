# Mike Urbano
# mxu2814
# 2018-09-22
#--------------------------------------------------
import re
import sys

#--------------------------------------------------
def processToken( token ) :
  ID = re.compile( '^[\\$a-z][\\dA-Z]*$|^[\\|][\\dA-Z]*[\\|]$' )
  INT = re.compile( '^[%][\\da-fA-F]+' )
  FP = re.compile( '^[\\d]+\\.[\\d]+' )
  result = ID.match(token)
  match = False
  if result:
    print( '>%s< matches ID' % ( token ) )
    match = True
  result = INT.match(token)
  if result:
    print( '>%s< matches INT' % ( token ) )
    match = True
  result = FP.match(token)
  if result:
    print( '>%s< matches FP' % ( token ) )
    match = True
  if not (match==True):
    print( '>%s< does not match' % ( token ) )

#--------------------------------------------------
def main() :
  fName = sys.argv[ 1 ]
  print( 'processing tokens from ' + fName + ' ...' )

  with open( fName, 'r' ) as fp :
    lines = fp.read().replace( '\r', '' ).split( '\n' )

  for line in lines :
    for token in line.split() :
      processToken( token )

#--------------------------------------------------
if ( __name__ == '__main__' ) :
  main()

#--------------------------------------------------
