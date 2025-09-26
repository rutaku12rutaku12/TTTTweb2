import * as React from 'react';
import List from '@mui/joy/List';
import ListItem from '@mui/joy/ListItem';
import ListItemDecorator, {
  listItemDecoratorClasses,
} from '@mui/joy/ListItemDecorator';
import ListItemContent from '@mui/joy/ListItemContent';
import ListItemButton from '@mui/joy/ListItemButton';
import Typography from '@mui/joy/Typography';
import Box from '@mui/joy/Box';
import ArrowDropDown from '@mui/icons-material/ArrowDropDown';
import InboxIcon from '@mui/icons-material/Inbox';
import Label from '@mui/icons-material/Label';
import People from '@mui/icons-material/People';
import Info from '@mui/icons-material/Info';
import Star from '@mui/icons-material/Star';

import { Link } from "react-router-dom";

export default function Hedaer(props){
      const [index, setIndex] = React.useState(0);
    return(<>  
    
             <Box sx={{ py: 2, pr: 2, width: 200 }}>
      <List
        aria-label="Sidebar"
        sx={{
          '--ListItem-paddingLeft': '0px',
          '--ListItemDecorator-size': '64px',
          '--ListItem-minHeight': '32px',
          '--List-nestedInsetStart': '13px',
          [`& .${listItemDecoratorClasses.root}`]: {
            justifyContent: 'flex-end',
            pr: '18px',
          },
          '& [role="button"]': {
            borderRadius: '0 20px 20px 0',
          },
        }}
      >
        <ListItem>
            <Link to={"/"}>
          <ListItemButton
            selected={index === 0}
            color={index === 0 ? 'neutral' : undefined}
            onClick={() => setIndex(0)}
          >
            <ListItemDecorator>
              <InboxIcon fontSize="lg" />
            </ListItemDecorator>
            <ListItemContent> 홈으로 </ListItemContent>
            <Typography
              level="body-sm"
              sx={{ fontWeight: 'bold', color: 'inherit' }}
            >
              
            </Typography>
          </ListItemButton>
          </Link>
        </ListItem>
        <ListItem>
            <Link to={"/menu"}>
          <ListItemButton
            selected={index === 1}
            color={index === 1 ? 'neutral' : undefined}
            onClick={() => setIndex(1)}
          >
            <ListItemDecorator>
              <Star fontSize="lg" />
            </ListItemDecorator>
            <ListItemContent> 제품 페이지 </ListItemContent>
          </ListItemButton>
          </Link>
        </ListItem>
        <ListItem nested>
            <Link to={"/cart"}>
          <ListItemButton
            selected={index === 2}
            color={index === 2 ? 'neutral' : undefined}
            onClick={() => setIndex(2)}
          >
            <ListItemDecorator>
              <Label fontSize="lg" />
            </ListItemDecorator>
             장바구니
          </ListItemButton>
          </Link>
        </ListItem>
      </List>
    </Box>
    </>)
}