/* Author : Ravi Kalla
 * Email  : ravikalla@ravikalla.in
 */
#define MAX_NODES 100
#define INFINITY 30000

int n,dist[MAX_NODES][MAX_NODES];

int shortest_path(int s,int t,int path[])
{	struct state
	{	int predecessor;
		int length;
		enum{permanent,tentative} label;
	}state[MAX_NODES];

	int i,k,min;
	struct state *p;

	for(p=&state[0];p<&state[n];p++)
	{	p->predecessor=-1;
		p->length=INFINITY;
		p->label=tentative;
	}
	state[t].length=0;
	state[t].label=permanent;
	k=t;
	do
	{	for(i=0;i<n;i++)
		{	if(dist[k][i]!=0 && state[i].label==tentative)
			{	if(state[k].length+dist[k][i]<state[i].length)
				{	state[i].predecessor=k;
					state[i].length=state[k].length+dist[k][i];
				}
			}
		}
		k=0;
		min=INFINITY;
		for(i=0;i<n;i++)
		{	if(state[i].label==tentative && state[i].length<min)
			{	min=state[i].length;
				k=i;
			}
		}
		state[k].label=permanent;
	}while(k!=s);
	i=0;
	k=s;
	do
	{	path[i++]=k;
		k=state[k].predecessor;
	}while(k>=0);
	return(i);
}
void main()
{   int i,j,path[100];
	printf("Enter no. of nodes:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{	for(j=0;j<=i;j++)
		{	if(i==j)
				dist[i][i]=0;
			else
			{	printf("Enter distance between %d & %d:",i,j);
				scanf("%d",&dist[i][j]);
				dist[j][i]=dist[i][j];
			}
		}
	}
	do
	{	printf("Enter the first node & last node to find minimum path:");
		scanf("%d %d",&i,&j);
		j=shortest_path(i,j,path);
		for(i=0;i<j;i++)
		{	printf("--->%d",path[i]);
		}
		printf("\nDo u continue?(y/n)");
	}while(getche()=='y');
}